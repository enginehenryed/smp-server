package net.swmaestro.portal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by junha on 2016. 10. 7..
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.swmaestro.portal"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .host("https://api.swmaestro.net");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SW Maestro Portal API")
                .description("API Document of SW Maestro Portal")
                .version("0.1")
                .build();
    }
}
