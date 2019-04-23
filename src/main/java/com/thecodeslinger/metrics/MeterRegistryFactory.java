package com.thecodeslinger.metrics;

import com.netflix.spectator.atlas.AtlasConfig;
import io.micrometer.atlas.AtlasMeterRegistry;
import io.micrometer.core.instrument.Clock;

import java.time.Duration;

public class MeterRegistryFactory {

    /**
     * Read the externalized values from the configuration file and set up the Atlas
     * {@link io.micrometer.core.instrument.MeterRegistry}.
     */
    public static AtlasMeterRegistry createRegistry(final AppConfiguration config) {
        final var meterConfig = new AtlasConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(2);
            }

            @Override
            public String get(String k) {
                if ("atlas.step".equalsIgnoreCase(k)) {
                    return "PT2S";
                }
                if ("atlas.uri".equalsIgnoreCase(k)) {
                    return config.getAtlasUri();
                }
                return null; // accept the rest of the defaults
            }
        };

        return new AtlasMeterRegistry(meterConfig, Clock.SYSTEM);
    }
}
