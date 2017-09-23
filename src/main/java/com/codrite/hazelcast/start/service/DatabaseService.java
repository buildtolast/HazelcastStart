package com.codrite.hazelcast.start.service;

import org.h2.jdbcx.JdbcConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Service
public class DatabaseService {

    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private JdbcConnectionPool jdbcConnectionPool;

    @Autowired
    public DatabaseService(JdbcConnectionPool jdbcConnectionPool) {
        this.jdbcConnectionPool = jdbcConnectionPool;
    }

    @PostConstruct
    public void assertConnectionValid() throws SQLException {
        Connection connection = jdbcConnectionPool.getConnection();
        DatabaseMetaData metadata = connection.getMetaData();
        logger.info(" Database major version : {} ", metadata.getDatabaseMajorVersion());
    }
}
