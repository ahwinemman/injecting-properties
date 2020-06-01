package com.javaee.injectprops.configuration;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


@Startup
@Singleton
public class ConfigurationManager {

    private Properties properties = System.getProperties();
    private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());
    private static final String path = "/application.properties";

    public static void main(String[] args) {
        System.out.println(new ConfigurationManager().getStringProperty("base_url"));
    }


    @PostConstruct
    private void getProperties() {

        InputStream inputStream = null;

        try {
            if (path != null) {
                LOGGER.info("Loading Configuration file");
                inputStream = this.getClass().getResourceAsStream(path);
                properties.load(inputStream);

            } else {
                LOGGER.severe("Failed to load configuration file");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error initialising configuration manager", ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Error closing inputstream", ex);
                }
            }
        }
    }

    public String getStringProperty(String key) {
        getProperties();
        return properties.getProperty(key);
    }

    public Integer getIntegerProperty(String key) {
        getProperties();
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
