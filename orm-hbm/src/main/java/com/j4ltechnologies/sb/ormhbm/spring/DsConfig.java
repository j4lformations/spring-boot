package com.j4ltechnologies.sb.ormhbm.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Classe DsConfig, créée le 26/05/2021 à 12:14
 * Author: Joachim Zadi
 * Version: 1.0 du 26/05/2021
 */
@Configuration
public class DsConfig {

    private static Logger logger = LoggerFactory.getLogger(DsConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            dbBuilder.setType(EmbeddedDatabaseType.H2);
            dbBuilder.addScripts("sql/schema-h2.sql", "sql/data-h2.sql");
            return dbBuilder.build();
        } catch (Exception e) {
            logger.info("\n============== Impossible de charger la Base de données H2 ==============\n");
            return null;
        }
    }
}