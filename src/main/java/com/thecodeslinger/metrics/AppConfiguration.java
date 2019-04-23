package com.thecodeslinger.metrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Merely exposes the configuration values in {@code application.properties} as a POJO.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Value("${atlas.uri}")
    private String atlasUri;

    public String getAtlasUri() {
        return atlasUri;
    }
}
