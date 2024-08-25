package com.Week45.bookstore.BookstoreAPI.config;



import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.endpoint.web.WebEndpointServlet;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpointExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {

    @Bean
    public WebEndpointExtension customActuatorExtension(WebEndpointProperties webEndpointProperties) {
        return new WebEndpointExtension() {
            // Customize your actuator endpoints here if needed
        };
    }
}
