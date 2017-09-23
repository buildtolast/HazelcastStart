package com.codrite.hazelcast.start.configuration;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${spring.database.connectionString}")
    private String connectionString;

    @Value("${spring.database.user}")
    private String user;

    @Value("${spring.database.password}")
    private String password;

    @Bean
    public JdbcConnectionPool getJdbcConnectionPool() {
        return JdbcConnectionPool.create(connectionString, user, password);
    }

}
