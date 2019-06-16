package com.camsofttech.phsarcambo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.core.env.Environment;

import java.util.Properties;

/**
 * @author : chhai chivon on 3/28/2019.
 * Software Engineer
 */

/*@Configuration
@PropertySource(value={"classpath:datasource.properties"})*/
public class DatasourceConfig extends WebMvcConfigurerAdapter {

    /*@Autowired
    private Environment environment;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("KS.dataSource.driverClassName"));
        dataSource.setUrl(environment.getProperty("KS.dataSource.url"));
        dataSource.setUsername(environment.getProperty("KS.dataSource.username"));
        dataSource.setPassword(environment.getProperty("KS.dataSource.password"));
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    @ConditionalOnBean(name = "dataSource")
    @ConditionalOnMissingBean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("kh.com.sathapana.ks.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        *//*if (additionalProperties() != null) {
            em.setJpaProperties(additionalProperties());
        }*//*
        return em;
    }*/

    /*@ConditionalOnResource(resources = "classpath:mysql.properties")
    @Conditional(HibernateCondition.class)
    Properties additionalProperties() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
                environment.getProperty("mysql-hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect",
                environment.getProperty("mysql-hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql",
                environment.getProperty("mysql-hibernate.show_sql") != null
                        ? environment.getProperty("mysql-hibernate.show_sql") : "false");
        return hibernateProperties;*/
}
