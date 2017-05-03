package gob.senado.ppf.sed.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

/**
 * Clase de configuracion que levanta la infraestructura de:
 * <ol>
 * <li>Instanciamiento y parametrización del <b>DataSource</b>, el cual sera el que levante el puente de conexión a la base de datos.</li>
 * <li>Instanciamiento de una implementacion de <b>PlatformTransactionManager</b>, este se encargara de realizar las transacciones
 * (commits, rollbacks, tipos de aislamiento, etc) en todos los services donde se coloque a un metodo la anotación <b>@Transactional</b>,
 * si no se anota un metodo con esta anotación NO habra una transaccion que administre ese servicio produciendo una falta de Integridad
 * referencial en caso de ser una transacción distribuida, es muy importante tener en cuenta que ademas de tener un metodo anotado con
 * <b>@Transactional</b> se necesita tener la anotación <b>@EnableTransactionManagement</b> sobre un clase que tenga la anotacion
 * <b>@Configuration</b> para que las Transacciones sean activadas, en caso contrario sin la anotación <b>@EnableTransactionManagement</b>
 * las transacciones no seran habilitadas.</li>
 * <li>Instanciamiento y configuración de la piscina de conexiones a la base de datos, la implementacion fue HikariCP, la cual desde el
 * DataSource tiene su propia implementacion: <b>HikariDataSource</b>, el cual recibe todos los parametros de configuración de nuestro
 * archivo <b>aplicacion/datasource.yml</b> y los almacena en una propiedad de la clase HikariConfig, que esta sera pasada al constructor
 * de la implementacion del DataSource.</li>
 * <li>Define el Bean JdbcTemplate que sera usado en todos nuestros <b>@Repositoy</b> de nuestra aplicación con todas las configuraciones contempladas para la persistencia
 * (pisina de conexions, transacciones, datasource, etc).</li>
 * </ol>
 * @see org.springframework.transaction.annotation.Transactional
 * @see org.springframework.transaction.annotation.EnableTransactionManagement
 * @see javax.sql.DataSource
 * @see com.zaxxer.hikari.HikariConfig
 * @see com.zaxxer.hikari.HikariDataSource
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.jdbc.core.JdbcTemplate
 * @author Benjamin Natanael Ocotzi Alvarez
 */
@Configuration
@EnableTransactionManagement
public class ConfiguracionParaDataSource {
    
    /** Varible que almacena el nombre de firma del Driver que se encargara de obtener el puente de conexión a la base de datos. */
    @Value("${driver}")
    private String driver;
    
    /** Variable que almacena la URL de la base de datos. */
    @Value("${url}")
    private String url;
    
    /** Variable que almacena el usuario de autenticacion para acceder a la base de datos. */
    @Value("${usuario}")
    private String usuario;
    
    /** Variable que almacena la contraseña de autenticacion para acceder a la base de datos. */
    @Value("${contrasena}")
    private String contrasena;
    
    /** 
     * Variable que almacena si los prepared statements seran habilitados para realizar una sustitución 
     * de todos los placeholders de una sentencia SQL por valores literales antes de enviarla al servidor 
     * para su ejecusión.
     */
    @Value("${cachePrepStmts}")
    private String cachePrepStmts;
    
    /** Variable que almacena el numero inicial de prepared statements que puede almacenar en cache. */
    @Value("${prepStmtCacheSize}")
    private String prepStmtCacheSize;
    
    /** Variable que almacena el numero maximo de prepared statements en cache. */
    @Value("${prepStmtCacheSqlLimit}")
    private String prepStmtCacheSqlLimit;
    
    /** Variable que almacena el numero maximo de conexiones de la pisina a la base de datos.  */
    @Value("${maximumPoolSize}")
    private String maximumPoolSize;
    
    /** Variable que almacena */
    @Value("${minimumIdle}")
    private String minimumIdle;
    
    /**  */
    @Value("${leakDetectionThreshold}")
    private String leakDetectionThreshold;
    
    /**  */
    @Value("${connectionTimeout}")
    private String connectionTimeout;
    
    
    @Bean
    @Scope("prototype")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig configParaHikari = new HikariConfig();
        configParaHikari.setDriverClassName(driver);
        configParaHikari.setJdbcUrl(url);
        configParaHikari.setUsername(usuario);
        configParaHikari.setPassword(contrasena);
        configParaHikari.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
        configParaHikari.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
        configParaHikari.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
        configParaHikari.setMaximumPoolSize(Integer.valueOf(maximumPoolSize));
        configParaHikari.setMinimumIdle(Integer.valueOf(minimumIdle));
        configParaHikari.setLeakDetectionThreshold(Integer.valueOf(leakDetectionThreshold));
        configParaHikari.setConnectionTimeout(Integer.valueOf(connectionTimeout));
        return configParaHikari;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
    
}