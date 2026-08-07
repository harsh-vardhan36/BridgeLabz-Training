package com.library_management_annotationBased.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Annotation-based Spring configuration.
 * Replaces the old applicationContext.xml:
 *   - @ComponentScan tells Spring which package to scan for @Component beans
 *   - @PropertySource loads external values (author.name, book.price, etc.)
 */
@Configuration
@ComponentScan(basePackages = "com.library_management_annotationBased")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
