package com.architecturelab.config;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Aman Kumar");
        contact.setEmail("amansibar02@gmail.com");
        contact.setUrl("https://github.com/amanjavahub-git/springboot-architecture-lab.git");
        Info info  = new Info()
                .title("Spring Boot Architecture Lab APIs")
                .version("1.0")
                .description("API documentations for cloud integrations")
                .contact(contact);
        return new OpenAPI()
                .info(info);
    }
}
