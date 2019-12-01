package fr.isty.iatic5.archilog.sessions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
@ComponentScan("fr.isty.iatic5.archilog.sessions.controller")

public class SwaggerConfig {

	/**
	 *
	 * @return Docket
	 */
	@Bean
	public Docket api() {
//Predicate<String> predicateUrl = PathSelectors.regex("")::apply;
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.basePackage("fr.isty.iatic5.archilog.sessions.controller"))
              //.paths(predicateUrl::test)
				.build();
	}

	/**
	 *
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Projet Sessions")
				.description("APIs Rest exposés dans le code du projet Sessions").version("1.0")
				.termsOfServiceUrl("Terms of service")
				.contact(new Contact("IATIC5", "https://isty.fr", "groupe9@isty.fr"))
				.license("Copyright (C) ISTY Groupe 9").licenseUrl("https://isty.fr").build();
	}
}
