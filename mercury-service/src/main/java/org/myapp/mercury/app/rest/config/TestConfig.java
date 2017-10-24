package org.myapp.mercury.app.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ComponentScan(basePackages = "org.myapp.mercury",

		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { WebMvcConfig.class,
				MercuryInitializer.class })

)
@Import(MercuryConfig.class)
@ActiveProfiles("integration-test")
public class TestConfig {

}
