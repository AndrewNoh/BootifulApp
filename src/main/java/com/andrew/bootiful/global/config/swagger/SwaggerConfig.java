package com.andrew.bootiful.global.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SwaggerConfig {
    // 접속 주소
    // http://localhost:8080/swagger-ui/index.html

    // 개발 환경에서만 Swagger UI 활성화
    @Bean
    @Profile("dev")
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("1_public")
                .pathsToMatch("/api/v*/**")
                .build();
    }

    @Bean
    @Profile("dev")
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("2_admin")
                .pathsToMatch("/admin/v*/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bootiful App API Documentation")
                        .version("1.0")
                        .description("Bootiful App API 문서입니다. 각 API의 세부 정보와 예제를 포함합니다."))
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Local Server")) // 로컬 서버 설명
                .addServersItem(new Server()
                        .url("need https server url")
                        .description("Production Server")); // 프로덕션 서버 설명
    }
}