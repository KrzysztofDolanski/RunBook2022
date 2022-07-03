package com.dola.runnerbook.config.map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.runbook.google-maps")
public class GoogleMapsClientProperties {

    private String token;


    public GoogleMapsClientProperties(String token) {
        this.token = token;
    }

    public GoogleMapsClientProperties() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
