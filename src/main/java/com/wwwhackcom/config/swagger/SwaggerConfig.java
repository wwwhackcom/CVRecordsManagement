package com.wwwhackcom.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import javax.annotation.Generated;
import static springfox.documentation.builders.PathSelectors.regex;

@Component
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ApiInfo apiInfo = new ApiInfo("", "", null, null, null, null, null);
        Docket docket = new Docket(DocumentationType.SWAGGER_2).select().paths(regex("^(?!.*error).*$")).build()
        .apiInfo(apiInfo).useDefaultResponseMessages(false);
        return docket;
    }
}
