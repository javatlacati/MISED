package gob.senado.ppf.sed.configuracion;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Clase de configuración que se encarga de cargar los archivos yml
 * para ser posteriormente asignados a las demas clases de configuración.
 *
 * @author Benjamin Natanael Ocotzi Alvarez
 */
@Configuration
@PropertySource("classpath:aplicacion/datasource.yml")
public class ConfiguracionParaExtras {

    /**
     * Constructor por defecto de la clase de configuracion ConfiguracionParaExtras.
     */
    public ConfiguracionParaExtras() {
    
    }
   
    /**
     * Bean de configuración que se encarga de leer todos los properties pero se ha cambiado la implementacion para
     * que lea archivo .yml de la carpeta aplicacion/.
     * @return PropertySourcesPlaceholderConfigurer objeto que lee los archivos .yml
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer ymlProperties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("aplicacion/datasource.yml"));
        pspc.setProperties(yaml.getObject());
        return pspc;
    }
    
}
