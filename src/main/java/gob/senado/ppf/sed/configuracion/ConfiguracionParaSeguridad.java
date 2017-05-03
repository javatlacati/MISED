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
 * Clase de configuraci�n que define las politicas de acceso hacia los controladores, niveles de acceso mediante roles, login y logout de la aplicaci�n.
 * @author Benjamin Natanael Ocotzi Alvarez
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionParaSeguridad extends WebSecurityConfigurerAdapter {
    
    /** Variable que almacena el puente de conexi�n a la base de datos. */
    private DataSource dataSource;
    
    /**
     * Consulta SQL que permite obtener la identidad (nombre de usuario) y la contrase�a hasheada de la tabla usuario junto con
     * sus permisos si la condici�n de que la identidad sea igual a la del valor literal y si tiene el permiso de autenticarse se cumple.
     */
    private static final String USUARIOS_POR_USUARIO = "SELECT U.IDENTIDAD, U.CLAVE_ACCESO, UP.PUEDE_AUTENTICARSE FROM USUARIO U " +
            "INNER JOIN USUARIO_PERMISO UP ON U.ID_USUARIO = UP.ID_USUARIO WHERE U.IDENTIDAD = ? AND UP.PUEDE_AUTENTICARSE = true";
    
    /**
     * Consulta SQL que permite obtener el rol de usuario de acuerdo a su identidad (nombre de usuario) y si tienen el permiso de autenticarse en la aplicaci�n.
     */
    private static final String AUTORIDADES_POR_USUARIO = "SELECT U.IDENTIDAD, U.ROL_DESIGNADO FROM USUARIO U INNER JOIN USUARIO_PERMISO UP " +
            "ON U.ID_USUARIO = UP.ID_USUARIO WHERE U.IDENTIDAD = ? AND UP.PUEDE_AUTENTICARSE = true";
    
    /**
     * Constante que almacena el limite maximo de sesiones POR USUARIO.
     */
    private static final int LIMITE_SESIONES_POR_USUARIO = 1;
    
    /**
     * Constructor de la clase ConfiguracionParaSeguridad que recibe un DataSource para realizar la autenticacion
     * y autorizacion (Roles y niveles de acceso) en base a su rol.
     * @param dataSource DataSource puente de conexi�n a la base de datos.
     */
    @Autowired
    public ConfiguracionParaSeguridad(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    
    /**
     * Metodo de configuraci�n que permite especificar que tipo de autenticaci�n, hasheo de contrase�as y consultas se manejaran
     * en la aplicaci�n para que un usuario tenga acceso.
     * @param auth AuthenticationManagerBuilder objeto de configuracion que define las politicas de Autenticaci�n
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery(ConfiguracionParaSeguridad.USUARIOS_POR_USUARIO)
                .authoritiesByUsernameQuery(ConfiguracionParaSeguridad.AUTORIDADES_POR_USUARIO);
    }
    
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
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    
}
