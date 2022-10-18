package ru.vallione.simple_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.vallione.simple_rest"))
                .paths(regex("/secured.*"))
                .build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Valentine Nazarov", "https://www.linkedin.com/in/nazarov-valentine/", "vallione@mail.ru");
        return new ApiInfo("Swagger2 API",
                "This is the simple Java REST application based on Swagger2",
                "1.0", "open-source",
                contact,
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }


}
