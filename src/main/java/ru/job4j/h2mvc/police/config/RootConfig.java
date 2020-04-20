package ru.job4j.h2mvc.police.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitaly Vasilyev, date: 02.04.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Configuration
@ComponentScan("ru.job4j.h2mvc.police")
@EnableJpaRepositories("ru.job4j.h2mvc.police")
@EnableTransactionManagement
public class RootConfig {
    /**
     * @return dataSource.
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/job4j_spring");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setInitialSize(5);
        return dataSource;
    }

    /**
     * @return синглтон EMF.
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        final Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("ru.job4j.h2mvc.police");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(map);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * @return менеджер транзакций.
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}