package gob.senado.ppf.sed.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

/**
 * Configuraci&oacute;n de seguidad de la aplicaci&oacute;n.
 * Define las pol&iacute;ticas de acceso hacia los controladores, niveles de acceso mediante roles, login y logout de la aplicaci&oacute;n.
 *
 * @author Benjamin Natanael Ocotzi Alvarez
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionParaSeguridad extends WebSecurityConfigurerAdapter {

    /**
     * Puente de conexi&oacute;n a la base de datos.
     */
    private DataSource dataSource;

    /**
     * Consulta que obtiene la identidad (nombre de usuario) y la contraseña hasheada de la tabla usuario junto con
     * sus permisos si la condición de que la identidad sea igual a la del valor literal y si tiene el permiso de autenticarse se cumple.
     */
    private static final String USUARIOS_POR_USUARIO = "SELECT U.IDENTIDAD, U.CLAVE_ACCESO, UP.PUEDE_AUTENTICARSE FROM USUARIO U " +
            "INNER JOIN USUARIO_PERMISO UP ON U.ID_USUARIO = UP.ID_USUARIO WHERE U.IDENTIDAD = ? AND UP.PUEDE_AUTENTICARSE = true";

    /**
     * Consulta que obtiene el rol de usuario de acuerdo a su identidad (nombre de usuario) con el permiso de autenticarse en la aplicaci&oacute;n.
     */
    private static final String AUTORIDADES_POR_USUARIO = "SELECT U.IDENTIDAD, U.ROL_DESIGNADO FROM USUARIO U INNER JOIN USUARIO_PERMISO UP " +
            "ON U.ID_USUARIO = UP.ID_USUARIO WHERE U.IDENTIDAD = ? AND UP.PUEDE_AUTENTICARSE = true";

    /**
     * L&iacute;mite m&aacute;ximo de sesiones por usuario del sistema.
     */
    private static final int LIMITE_SESIONES_POR_USUARIO = 1;

    /**
     * Crea la configuración de seguridad con la ayuda de un orígen de datos.
     * <p>
     * Parar el caso de esta aplicación el origen de datos será una base de datos.
     *
     * @param dataSource puente de conexión a la base de datos.
     */
    @Autowired
    public ConfiguracionParaSeguridad(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    /**
     * Configura el proceso de autentificaci&oacute;n.
     * Permite especificar que tipo de autenticaci&oacute;n, hasheo de contrase&ntilde;as y consultas se manejar&aacute;n
     * en la aplicaci&oacute;n para que un usuario tenga acceso.
     *
     * @param auth objeto que contiene las pol&iacute;ticas de Autenticaci&oacute;n
     * @throws Exception si el oigen de la informaci&oacute;n no existe o la consulta SQL esta mal escrita.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery(ConfiguracionParaSeguridad.USUARIOS_POR_USUARIO)
                .authoritiesByUsernameQuery(ConfiguracionParaSeguridad.AUTORIDADES_POR_USUARIO);
    }

    /**
     * Configura la seguridad de las comunicaciones entre el navegador del usuario y el servidor.
     * <br>
     * Para ello:
     * <ol>
     * <li>Filtra contenido XSS en una petici&oacute;n.</li>
     * <li>Filtra peticiones de acuerdo a los roles de usuario</li>
     * <li>Redirecciona a una pagina de inicio si la autenticaci&oacute;n es correcta en caso contrario a otra</li>
     * <li>Registra de sesiones( se limita a una sesi&oacute;n por usuario y navegador)</li>
     * </ol>
     *
     * @param http objeto que permite configurar la seguridad para las peticiones.
     * @throws Exception cuando hay alg[un problema al configurar
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8", true);
        http.addFilterBefore(filter, CsrfFilter.class);
        http.headers()
                .xssProtection()
                .xssProtectionEnabled(true)
                .block(true);
        http.authorizeRequests()
                .antMatchers("/administrador/**").hasRole("ADMINISTRADOR")
                .antMatchers("/inicio-sesion", "/inicio.htm", "/").permitAll()
                .antMatchers("/forgot", "/forgot.htm").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/inicio-sesion").permitAll()
                .defaultSuccessUrl("/inicio.htm")
                .failureUrl("/inicio-sesion?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/cierre-sesion")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/inicio-sesion?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/error/403")
                .and()
                .sessionManagement()
                .maximumSessions(LIMITE_SESIONES_POR_USUARIO)
                .sessionRegistry(sessionRegistry());
    }

    /**
     * Como parte de la configuración de seguridad ignora recursos que no se debend e mostrar al usuario.
     * Ignora el contenido de la carpeta resources (recursos de la aplicacion tales como las hojas de estilos,
     * scripts, etc).
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     * Obtiene una codificador de cadenas.
     *
     * @return Cifrador de contrase&ntilde;as para cadenas de texto.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Guardar un registro de las sesiones de usuario.
     *
     * @return SessionRegistry objeto que almacena el numero de sesiones activas en la aplicaci&oacute;n.
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

}
