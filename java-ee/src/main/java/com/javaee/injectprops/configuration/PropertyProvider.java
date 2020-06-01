package com.javaee.injectprops.configuration;


import com.javaee.injectprops.annotations.IntegerProperty;
import com.javaee.injectprops.annotations.StringProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
public class PropertyProvider {

    @Inject
    private ConfigurationManager configurationManager;

    @Produces
    @IntegerProperty
    Integer getIntegerPropertyValue(InjectionPoint ip) {
        return configurationManager.getIntegerProperty(ip.getAnnotated().getAnnotation(IntegerProperty.class).value());
    }

    @Produces
    @StringProperty
    String getStringPropertyValue(InjectionPoint ip) {
        return configurationManager.getStringProperty(ip.getAnnotated().getAnnotation(StringProperty.class).value());
    }
}
