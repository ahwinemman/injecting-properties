package com.spring.injectprops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MainClass implements CommandLineRunner {

    @Value("${base_url}")
    private String baseUrl;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("The value of the baseUrl is : " + baseUrl);
        LOGGER.info("The value of the username is : " + username);
        LOGGER.info("The value of the password is : " + password);

    }
}
