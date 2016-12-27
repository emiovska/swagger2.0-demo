package com.demo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.demo.config.swagger.SwaggerResponseMessage.buildResponseMessages;

/**
 * Created by elena.miovska on 26.12.2016 г..
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(SwaggerCustomApiInfo.apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, buildResponseMessages())
                .globalResponseMessage(RequestMethod.GET, buildResponseMessages());
    }

}



