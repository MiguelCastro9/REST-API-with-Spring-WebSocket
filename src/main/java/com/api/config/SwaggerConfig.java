package com.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Miguel Castro
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {

        return new OpenAPI()
                .info(new Info()
                        .title("API Service")
                        .version("v1")
                        .description("REST API com Spring WebSocket"));
    }
}
