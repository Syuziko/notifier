package com.sflpro.notifier.db.initializer.impl;

import com.sflpro.notifier.db.initializer.DbMigration;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Properties;

/**
 * User: Syuzanna Eprikyan
 * Company: SFL LLC
 * Date: 5/4/2019
 * Time: 4:31 PM
 */
//@PropertySource(value = {
//        "classpath:ms_notifications_integrationtest.properties"},
//        ignoreResourceNotFound = true)
@Component
public class DbMigrationImpl implements DbMigration {

    @Value("${spring.datasource.username}")
    private String databaseUserName;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Value("${spring.datasource.url}")
    private String databaseConnectionUrl;

    @Value("${flyway.db.vendor}")
    private String vendor;

    @Override
    public void migrate() {
// Grab the total duration of the process
//        final Flyway flyway = new Flyway();
//        flyway.setDataSource(databaseConnectionUrl, databaseUserName, databasePassword);
//        final Properties properties = new Properties();
//        properties.setProperty("flyway.driver", vendor);
//        properties.setProperty("flyway.locations", "db/migration/" + vendor);
//        flyway.configure(properties);
//        final int migrationResult = flyway.migrate();
//        System.out.println("Result " + migrationResult);
    }
}
