package gob.senado.ppf.sed.configuracion;

import gob.senado.ppf.sed.utilidades.Consultas;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class InicializadorAplicacionWeb implements WebApplicationInitializer {

    //    JdbcTemplate template;
    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ConfiguracionParaExtras.class, ConfiguracionParaDataSource.class,
                ConfiguracionParaWebSocket.class, ConfiguracionParaWebSocketHandlers.class,
                ConfiguracionParaSeguridad.class, Consultas.class);

        //filters
        // Add cuatom filters to servletContext
        FilterRegistration.Dynamic filterRegistration = container.addFilter("filtroXSS", new FiltroXSS());
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forceEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(ConfiguracionParaWeb.class);

        // Register and map the dispatcher servlet
        DispatcherServlet servletDisp = new DispatcherServlet(dispatcherServlet);
        servletDisp.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
                servletDisp);
        dispatcher.setAsyncSupported(true);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
//        File
//        template.execute();
    }

}
