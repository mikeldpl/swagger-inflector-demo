package com.github.mikeldpl.inflector.app;

import com.github.mikeldpl.inflector.ContextConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.swagger.inflector.SwaggerInflector;
import io.swagger.inflector.config.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Main extends Application<ApplicationConfig> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    public void run(ApplicationConfig configuration, Environment environment) throws Exception {
        WebApplicationContext context = confApplicationContext();
        SwaggerInflector swaggerInflector = confSwaggerInflector(context);

        environment.servlets().addServletListeners(new ContextLoaderListener(context));

        environment.jersey().packages("com.github.mikeldpl.inflector");
        environment.jersey().getResourceConfig().registerResources(swaggerInflector.getResources());
        environment.jersey().getResourceConfig().registerClasses(swaggerInflector.getClasses());
        environment.jersey().getResourceConfig().registerInstances(swaggerInflector.getInstances());
    }

    private SwaggerInflector confSwaggerInflector(WebApplicationContext context) {
        Configuration swaggerConfig = Configuration.read();
        swaggerConfig.setControllerFactory((cls, operation) -> context.getBean(cls));
        return new SwaggerInflector(swaggerConfig);
    }

    private AnnotationConfigWebApplicationContext confApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ContextConfiguration.class);
        context.refresh();
        return context;
    }
}
