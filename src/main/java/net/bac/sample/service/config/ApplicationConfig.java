package net.bac.sample.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.bac.sample.service.SampleConfig;

/**
 * @author gdiazs
 */
@Configuration
@Import(SampleConfig.class)
public class ApplicationConfig {
}
