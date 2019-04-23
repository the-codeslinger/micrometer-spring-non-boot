package com.thecodeslinger.metrics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Load the Spring context from the classpath to get things running.
 */
public class MicrometerSpringXml
{
    public static void main( String[] args ) {
        // This is classic Spring.
        new ClassPathXmlApplicationContext("application-context.xml");
    }
}
