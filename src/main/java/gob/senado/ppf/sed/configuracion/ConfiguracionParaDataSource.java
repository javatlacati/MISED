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

@Configuration
@EnableTransactionManagement
public class ConfiguracionParaDataSource {
	
	@Value("${driver}")
	private String driver;

	@Value("${url}")
	private String url;

	@Value("${usuario}")
	private String usuario;

	@Value("${contrasena}")
	private String contrasena;
	
	@Value("${cachePrepStmts}")
	private String cachePrepStmts;
	
	@Value("${prepStmtCacheSize}")
	private String prepStmtCacheSize;
	
	@Value("${prepStmtCacheSqlLimit}")
	private String prepStmtCacheSqlLimit;
	
	@Value("${maximumPoolSize}")
	private String maximumPoolSize;
	
	@Value("${minimumIdle}")
	private String minimumIdle;
	
	@Value("${leakDetectionThreshold}")
	private String leakDetectionThreshold;
	
	@Value("${connectionTimeout}")
	private String connectionTimeout;
	

	@Bean
	@Scope("prototype")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
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
