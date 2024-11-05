package com.andrew.bootiful.global.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public abstract class BaseDatabaseConfig {

    @Value("${spring.datasource.username}")
    protected String username;

    @Value("${spring.datasource.password}")
    protected String password;

    protected abstract String getPoolName();

    protected abstract String getJdbcUrl();

    protected abstract String getDriverClassName();

    @Bean
    public DataSource dataSource() {
        return createDataSource();
    }

    private DataSource createDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setPoolName(getPoolName());
        hikariDataSource.setDriverClassName(getDriverClassName());
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setJdbcUrl(getJdbcUrl());
        hikariDataSource.setConnectionTestQuery("SELECT 1");
        hikariDataSource.setConnectionTimeout(300);
        hikariDataSource.setMaximumPoolSize(10);
        hikariDataSource.setMinimumIdle(2);
        return hikariDataSource;
    }
}