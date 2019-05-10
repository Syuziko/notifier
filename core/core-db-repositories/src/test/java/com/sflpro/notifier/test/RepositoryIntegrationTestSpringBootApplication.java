package com.sflpro.notifier.test;

import org.springframework.context.annotation.PropertySource;

/**
 * Company: SFL LLC
 * Created on 1/22/18
 *
 * @author Yervand Aghababyan
 */
//@SpringBootApplication
//@EnableAutoConfiguration
@PropertySource({"classpath:repositories_integration_test.properties", "classpath:com/sflpro/notifier/repositories.properties"})
public class RepositoryIntegrationTestSpringBootApplication {
}
