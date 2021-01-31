package com.lovemesomecoding.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AppConfig {

    /**
     * Override default flyway initializer to do nothing
     */
    @Bean
    FlywayMigrationInitializer flywayInitializer() {
        return new FlywayMigrationInitializer(setUpFlyway(), (f) -> {// do nothing
        });
    }

    /**
     * Create a second flyway initializer to run after jpa has created the schema
     */
    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer() {
        Flyway flyway = setUpFlyway();
        return new FlywayMigrationInitializer(flyway, null);
    }

    private Flyway setUpFlyway() {
        
        log.info("Configuring {} datasource...");

        Integer port = 3306;
        String host = "localhost";
        String username = "root";
        String password = "";
        String dbName = "springboot_oauth2";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

        FluentConfiguration configuration = Flyway.configure().dataSource(url, username, password);
        configuration.schemas(dbName);
        configuration.baselineOnMigrate(true);
        return configuration.load();
    }
}
