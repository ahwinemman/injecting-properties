package com.javaee.injectprops;

import com.javaee.injectprops.annotations.StringProperty;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
@Startup
public class MainClass {

    @Inject
    @StringProperty(value = "base_url")
    private String baseUrl;

    @Inject
    @StringProperty(value = "username")
    private String username;

    @Inject
    @StringProperty(value = "password")
    private String password;

    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());


    @PostConstruct
    public void logPropertyValues() {

        LOGGER.info("The value of the baseUrl is : " + baseUrl);
        LOGGER.info("The value of the username is : " + username);
        LOGGER.info("The value of the password is : " + password);

    }
}
