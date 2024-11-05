package com.andrew.bootiful.global.config.database;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("dev")
public class H2DatabaseConfig extends BaseDatabaseConfig {

    @Override
    protected String getPoolName() {
        return "h2";
    }

    @Override
    protected String getJdbcUrl() {
        return "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    }

    @Override
    protected String getDriverClassName() {
        return "org.h2.Driver";
    }
}
