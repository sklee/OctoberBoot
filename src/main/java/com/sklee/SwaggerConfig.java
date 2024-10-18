package com.sklee;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

		@Bean
		OpenAPI openAPI() {
			return new OpenAPI().components(new Components()).info(apiInfo());
		}

		private Info apiInfo() {
			return new Info()
					.title("스웨거 연습")
					.description("중앙학원 705교실 poseidon")
					.version("1.0.0");
		}
}
