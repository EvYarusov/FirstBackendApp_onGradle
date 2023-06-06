package com.example.ticketShop;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloAppOnGradleApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(HelloAppOnGradleApplication.class, args);
    }

    @Bean
    public OpenAPI baseOpenApi()
    {
        return new OpenAPI().info(new Info()
                .title("Ticket shop")
                .version("1.0.0")
                .description("Ticket shop REST API")
        );
    }
}
