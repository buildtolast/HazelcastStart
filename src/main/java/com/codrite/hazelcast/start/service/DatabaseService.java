package com.codrite.hazelcast.start.service;

import org.h2.jdbcx.JdbcConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class DatabaseService {

    private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${database.sqlfile}")
    private String sqlFile;

    private JdbcConnectionPool jdbcConnectionPool;

    @Autowired
    public DatabaseService(JdbcConnectionPool jdbcConnectionPool) {
        this.jdbcConnectionPool = jdbcConnectionPool;
    }

    @PostConstruct
    public void initialization() throws SQLException, IOException {
        Connection connection = jdbcConnectionPool.getConnection();
        DatabaseMetaData metadata = connection.getMetaData();
        logger.info(" Database major version : {} ", metadata.getDatabaseMajorVersion());

        initTables();
    }

    private void initTables() throws SQLException, IOException {
        try (Connection connection = jdbcConnectionPool.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                List<String> allLines = Files.readAllLines(Paths.get(new ClassPathResource(sqlFile).getURI()));
                for (final String eachSql : allLines) {
                    statement.addBatch(eachSql);
                }
                statement.executeBatch();
            }
        }
    }

}
