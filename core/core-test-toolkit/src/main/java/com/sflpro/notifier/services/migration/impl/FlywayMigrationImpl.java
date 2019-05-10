package com.sflpro.notifier.services.migration.impl;

import com.sflpro.notifier.services.migration.FlywayMigration;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * User: Syuzanna Eprikyan
 * Company: SFL LLC
 * Date: 5/8/19
 * Time: 11:28 AM
 */
@Component
public class FlywayMigrationImpl implements FlywayMigration {

    @Override
    public void migrate() {
        final Flyway flyway = new Flyway();
        flyway.setDataSource(System.getProperty("database.url"), System.getProperty("database.username"), System.getProperty("database.password"));
        flyway.configure(getProperties());
        flyway.migrate();
    }

    private Properties getProperties() {
        Properties properties = new Properties();
//        properties.setProperty("flyway.dirver", System.getProperty("testcontainer.datasource.driver"));
        properties.setProperty("flyway.locations", "db/migration/" + System.getProperty("testcontainer.datasource.driver"));
        return properties;
    }
}
