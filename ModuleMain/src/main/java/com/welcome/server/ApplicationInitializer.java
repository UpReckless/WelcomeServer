package com.welcome.server;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.welcome.server.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by royal on 10/3/16.
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER = "welcome_dispatcher";

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(DISPATCHER, new DispatcherServlet(ctx));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream("E:\\IdeaProjects\\WelcomeServer\\ModuleMain\\src\\main\\resources\\WelcomePush-c160a6e929f1.json"))
                    .setDatabaseUrl("https://welcomepush-96f73.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load json file");
        }

    }
}
