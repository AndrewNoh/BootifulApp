package com.andrew.bootiful.global.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("prod")
public class MariaDBConfig extends BaseDatabaseConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Override
    protected String getPoolName() {
        return "mariadb";
    }

    @Override
    protected String getJdbcUrl() {
        return url;
    }

    @Override
    protected String getDriverClassName() {
        return driverClassName;
    }
}