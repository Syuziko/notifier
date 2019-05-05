package com.sflpro.notifier.test;

import com.sflpro.notifier.db.initializer.DbMigration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: Ruben Dilanyan
 * Company: SFL LLC
 * Date: 10/01/14
 * Time: 10:18 PM
 */
@SpringBootTest(classes = {RepositoryIntegrationTestSpringBootApplication.class})
@ActiveProfiles("test")
@ContextConfiguration("classpath:applicationContext-persistence-integrationtest.xml")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
public abstract class AbstractRepositoryTest {

    /* Dependencies */
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DbMigration databaseMigrationService;

    /* Constructors */
    public AbstractRepositoryTest() {

    }

    @Before
    public void initDatabase() {
        databaseMigrationService.migrate();
    }

    /* Utility methods */
    protected void flush() {
        em.flush();
    }

    protected void clear() {
        em.clear();
    }

    protected void flushAndClear() {
        em.flush();
        em.clear();
    }
}
