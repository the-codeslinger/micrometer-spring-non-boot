package com.thecodeslinger.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

/**
 * The most stupid metric generator on the planet. But, it creates metrics like a beast.
 * That's the only thing it has going for it.
 */
public class DataGenerator {

    // Not required as a parameter in this example. Only used to demonstrate that it can.
    private MeterRegistry registry;
    private Counter counter;

    public DataGenerator(MeterRegistry registry) {
        this.registry = registry;
        this.counter = registry.counter("custom.beast.counter", "generator", "metrics");
    }

    /**
     * Called every 5 seconds by the Spring scheduler.
     */
    public void createMetricsLikeABeast() {
        counter.increment();
    }
}
