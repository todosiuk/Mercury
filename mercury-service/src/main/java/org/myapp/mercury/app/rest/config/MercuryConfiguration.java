package org.myapp.mercury.app.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.myapp.mercury.app")
@EnableWebMvc
public class MercuryConfiguration {

}
