package co.edu.unbosque.electroshop_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures Swagger documentation for the ElectroShop API.
 * <p>
 * This configuration class sets up Swagger to generate API documentation for the ElectroShop application.
 * It provides details about the API, including its title, version, and description, and configures
 * the packages to scan for controllers, models, services, and repositories to include in the documentation.
 * </p>
 * @see co.edu.unbosque.electroshop_api
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.model
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.repository
 */
@Configuration
public class SwaggerConfig {

	/**
     * Creates a bean for customizing the OpenAPI documentation.
     * <p>
     * This method sets up basic information for the API documentation, including the title, version, and description
     * of the ElectroShop API. It is used by Swagger to generate the OpenAPI specification.
     * </p>
     * 
     * @return an {@link OpenAPI} instance with the configured API information
     */
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("ElectroShop API")
	                        .version("1.0.0")
	                        .description("This API is in charge of processing and confirming orders for the company ElectroShop.")
	                );
	    }

	 /**
	     * Creates a bean for grouping and configuring the public API documentation.
	     * <p>
	     * This method configures Swagger to include controllers and models from specified packages
	     * in the documentation under the "public" group.
	     * </p>
	     * 
	     * @return a {@link GroupedOpenApi} instance configured for the "public" group
	     */
	 	@Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("public")
	                .packagesToScan("co.edu.unbosque.electroshop_api.controller", 
	                                "co.edu.unbosque.electroshop_api.model")
	                .build();
	    }

}
