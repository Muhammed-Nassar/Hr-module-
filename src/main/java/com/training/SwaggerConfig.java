package com.training;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket productAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.training")).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfo("HR APIs Documents Made BY Nassar"
                , "Resful APIS "
                , "Version"
                , "serviceURL"
                , new Contact("Nassar", "www.nassar.com", "m.nasssar@gmail.com")
                , "jetBrinLics", "LicenseURL"
                , Collections.emptyList());
    }
}
