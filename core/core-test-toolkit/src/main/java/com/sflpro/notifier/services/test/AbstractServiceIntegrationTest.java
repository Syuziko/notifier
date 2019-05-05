package com.sflpro.notifier.services.test;

import com.sflpro.notifier.services.helper.ServicesTestHelper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ruben Dilanyan
 *         Aug 25, 2013
 */
@ActiveProfiles("test")
@SpringBootTest(classes = {ServiceIntegrationTestSpringBootApplication.class})
@ContextConfiguration("classpath:applicationContext-services-integrationtest.xml")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ServicesTestHelper servicesTestHelper;

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private DbMigration databaseMigrationService;

    public AbstractServiceIntegrationTest() {
    }

//    @Before
//    public void initDb() {
//        databaseMigrationService.migrate();
//    }

    /* Utility methods */
    protected void flush() {
        entityManager.flush();
    }

    protected void clear() {
        entityManager.clear();
    }

    protected void flushAndClear() {
        flush();
        clear();
    }

    /* Properties */
    public ServicesTestHelper getServicesTestHelper() {
        return servicesTestHelper;
    }
}
