package gob.senado.ppf.sed.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Levanta la infraestructura de:
 * <ol>
 * <li>Instanciamiento y parametrizaci&oacute;n del <b>DataSource</b>, el cual sera el que levante el puente de conexi&oacute;n a la base de datos.</li>
 * <li>Instanciamiento de una implementacion de <b>PlatformTransactionManager</b>, este se encargara de realizar las transacciones
 * (commits, rollbacks, tipos de aislamiento, etc) en todos los services donde se coloque a un metodo la anotaci&oacute;n <b>@Transactional</b>,
 * si no se anota un metodo con esta anotaci&oacute;n NO habra una transaccion que administre ese servicio produciendo una falta de Integridad
 * referencial en caso de ser una transacci&oacute;n distribuida, es muy importante tener en cuenta que ademas de tener un metodo anotado con
 * <b>@Transactional</b> se necesita tener la anotaci&oacute;n <b>@EnableTransactionManagement</b> sobre un clase que tenga la anotacion
 * <b>@Configuration</b> para que las Transacciones sean activadas, en caso contrario sin la anotaci&oacute;n <b>@EnableTransactionManagement</b>
 * las transacciones no seran habilitadas.</li>
 * <li>Instanciamiento y configuraci&oacute;n de la piscina de conexiones a la base de datos, la implementacion fue HikariCP, la cual desde el
 * DataSource tiene su propia implementacion: <b>HikariDataSource</b>, el cual recibe todos los parametros de configuraci&oacute;n de nuestro
 * archivo <b>aplicacion/datasource.yml</b> y los almacena en una propiedad de la clase HikariConfig, que esta sera pasada al constructor
 * de la implementacion del DataSource.</li>
 * <li>Define el Bean JdbcTemplate que sera usado en todos nuestros <b>@Repositoy</b> de nuestra aplicaci&oacute;n con todas las configuraciones 
 * contempladas para la persistencia (pisina de conexions, transacciones, datasource, etc).</li>
 * </ol>
 *
 * @see org.springframework.transaction.annotation.Transactional
 * @see org.springframework.transaction.annotation.EnableTransactionManagement
 * @see javax.sql.DataSource
 * @see com.zaxxer.hikari.HikariConfig
 * @see com.zaxxer.hikari.HikariDataSource
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.jdbc.core.JdbcTemplate
 */
@Configuration
@EnableTransactionManagement
public class ConfiguracionParaDataSource {

    /**
     * Nombre de firma del Driver que se encargara de obtener el puente de conexi&oacute;n a la base de datos.
     */
    @Value("${driver}")
    private String driver;

    /**
     * URL de la base de datos.
     */
    @Value("${url}")
    private String url;

    /**
     * Usuario de autenticacion para acceder a la base de datos.
     */
    @Value("${usuario}")
    private String usuario;

    /**
     * Contrase&ntilde;a de autenticaci&oacute;n para acceder a la base de datos.
     */
    @Value("${contrasena}")
    private String contrasena;

    /**
     * Almacena si los prepared statements seran habilitados para realizar una sustituci&oacute;n
     * de todos los placeholders de una sentencia SQL por valores literales antes de enviarla al servidor
     * para su ejecusi&oacute;n.
     */
    @Value("${cachePrepStmts}")
    private String cachePrepStmts;

    /**
     * N&uacute;mero inicial de prepared statements que puede almacenar en cache.
     */
    @Value("${prepStmtCacheSize}")
    private String prepStmtCacheSize;

    /**
     * N&uacute;mero maximo de prepared statements en cache.
     */
    @Value("${prepStmtCacheSqlLimit}")
    private String prepStmtCacheSqlLimit;

    /**
     * N&uacute;mero m&aacute;ximo de conexiones de la piscina a la base de datos.
     */
    @Value("${maximumPoolSize}")
    private String maximumPoolSize;

    /**
     * Tiempo m&iacute;nimo que una conexion puede permanecer sin realizar ninguna transacci&oacute;n antes de ser devuelta a la pisina de conexiones.
     */
    @Value("${minimumIdle}")
    private String minimumIdle;

    /**
     * Tiempo en que una conexi&oacute;n puede estar fuera del pool de conexiones sin recibir ningun log indicando que hay 
     * posiblemente un estancamiento de la conexi&oacute;n.
     */
    @Value("${leakDetectionThreshold}")
    private String leakDetectionThreshold;

    /**
     * Tiempo para la espera de recibir una nueva conexi&oacute;n desde el pool.
     * El tiempo se especifica en milisegundos .
     */
    @Value("${connectionTimeout}")
    private String connectionTimeout;

    /**
     * Bean de configuraci&oacute;n que crea un JbdcTemplate reutilizable para las capas superiores.
     *
     * @return JdbcTemplate que permite realizar consultar y transacciones a las demas capas superiores.
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    /**
     * Bean de configuraci&oacute;n que crea un objeto que almacena las propiedades de la configuraci&oacute;n para la pisina de conexiones a la base de datos.
     *
     * @return HikariConfig objeto que guarda las propiedades para la conexi&oacute;n a la base de datos y la pisina de conexiones.
     */
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

    /**
     * Bean de configuraci&oacute;n que administra las transacciones a la base de datos.
     *
     * @param dataSource DataSource que crea el puente de conexi&oacute;n a la base de datos.
     * @return PlatformTransactionManager que administra las transacciones de los metodos que tengan la anotaci&oacute;n @Transactional.
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Bean de configuraci&oacute;n que retorna una implementaci&oacute;n de un DataSource que establece el puente de conexi&oacute;n a la base de datos.
     *
     * @return DataSource implementado por Hikari.
     */
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

}
