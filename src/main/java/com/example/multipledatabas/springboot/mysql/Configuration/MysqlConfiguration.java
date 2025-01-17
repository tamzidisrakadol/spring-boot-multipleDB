package com.example.multipledatabas.springboot.mysql.Configuration;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multipledatabas.springboot.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlConfiguration {

    /**
     * Defines the MySQL EntityManagerFactory bean, responsible for managing the persistence context
     * for MySQL entities. This is marked as the primary EntityManagerFactory.
     *
     * @param builder  The EntityManagerFactoryBuilder used to construct the factory.
     * @param dataSource The DataSource for the MySQL database.
     * @return A configured LocalContainerEntityManagerFactoryBean for MySQL.
     */

    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDataSource") DataSource dataSource
    ){
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql",true);
        properties.put("hibernate.format_sql",true);
        properties.put("hibernate.hbm2ddl.auto","update");

        return builder.dataSource(dataSource)
                .packages("com.example.multipledatabas.springboot.mysql.Entity")
                .properties(properties)
                .persistenceUnit("mysql")
                .build();
    }

    /**
     * Defines the TransactionManager for MySQL, responsible for managing database transactions.
     *
     * @param entityManagerFactory The EntityManagerFactory for MySQL.
     * @return A PlatformTransactionManager configured for MySQL.
     */

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }


    /**
     * Defines the MySQL DataSource bean, providing the connection details to the MySQL database.
     * Marked as the primary DataSource in case multiple DataSources exist in the application.
     *
     * @return A DataSource configured with MySQL connection details.
     */

    @Bean(name = "mysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder.create().build();
    }
}
