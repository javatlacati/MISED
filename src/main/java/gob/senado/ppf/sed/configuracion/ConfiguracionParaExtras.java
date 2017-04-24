package gob.senado.ppf.sed.configuracion;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:aplicacion/datasource.yml")
public class ConfiguracionParaExtras {

	@Bean
	public static PropertySourcesPlaceholderConfigurer ymlProperties() {
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("aplicacion/datasource.yml"));
		pspc.setProperties(yaml.getObject());
		return pspc;
	}

}
