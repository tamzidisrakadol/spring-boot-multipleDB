package com.example.springbootmultipleDB.POSTGRESQL.config;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerBean",
        basePackages = {"com.example.springbootmultipleDB.POSTGRESQL.Repo"},
        transactionManagerRef = "secondTransaction"
)
public class PostgreSqlConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "secondDataSource")
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("second.datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
        dataSource.setUsername(environment.getProperty("second.datasource.username"));
        dataSource.setPassword(environment.getProperty("second.datasource.password"));
        return dataSource;
    }

    @Bean(name = "secondEntityManagerBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("com.example.springbootmultipleDB.POSTGRESQL.Model");
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hdm2ddl.auto","update");
        bean.setJpaPropertyMap(props);
        return bean;
    }


    @Primary
    @Bean(name = "secondTransaction")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }



}
