package com.sflpro.notifier.db.initializer;

import org.junit.ClassRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * User: Syuzanna Eprikyan
 * Company: SFL LLC
 * Date: 5/4/2019
 * Time: 4:18 PM
 */
@Lazy(false)
@Configuration
public class DbInitializer {

    @ClassRule
    private PostgreSQLContainer postgresContainer = new PostgreSQLContainer("postgres:9.6.8");
//    private MySQLContainer postgresContainer = new MySQLContainer("mysql:5.6.44");

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

//    static {
//        postgresContainer = ;
//        Runtime.getRuntime().addShutdownHook(new Thread(postgresContainer::stop));
////        postgresContainer.start();
//
//    }

    @Bean(name = "datasource")
    public DataSource dataSource() {
        postgresContainer.start();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(postgresContainer.getDriverClassName());
        dataSource.setUrl(postgresContainer.getJdbcUrl());
        dataSource.setUsername(postgresContainer.getUsername());
        dataSource.setPassword(postgresContainer.getPassword());
        System.setProperty("spring.datasource.driverClassName", postgresContainer.getDriverClassName());
        System.setProperty("spring.datasource.username", postgresContainer.getUsername());
        System.setProperty("spring.datasource.password", postgresContainer.getPassword());
        System.setProperty("spring.datasource.url", postgresContainer.getJdbcUrl());
        System.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
        System.setProperty("flyway.db.vendor", "postgresql");
        return dataSource;
    }

//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
////        entityManagerFactoryBean.setPackagesToScan("digital.weadapt.core.db");
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        entityManagerFactoryBean.setJpaProperties(getProperties());
//        return entityManagerFactoryBean;
//    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        properties.setProperty("hibernate.use_second_level_cache", "false");
        properties.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.jcache.JCacheRegionFactory");

        return properties;
    }
}
