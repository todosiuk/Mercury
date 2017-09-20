package org.myapp.mercury.app.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.myapp.mercury")
@EnableWebMvc
public class MercuryConfiguration {

}
