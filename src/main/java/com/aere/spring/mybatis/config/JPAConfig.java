package com.aere.spring.mybatis.config;

import com.aere.spring.env.config.EnvConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


/**
 * Created by epxpxpx on 5/26/2016.
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:/db.properties"),
        @PropertySource(value = "file:/C:\\Users\\AereXu\\OneDrive\\Workplace\\config\\SpringAll\\daasource.properties",
                ignoreResourceNotFound = true)
})
//@Import(EnvConfig.class) // Enable PlaceholderConfigurer Bean to support @Value("${datasource.url}") format
@MapperScan(basePackages = "com.aere.spring.mybatis.dao")
public class JPAConfig {

    @Value("${datasource.url}")
    private String PROPERTY_DATASOURCE_URL;

    @Value("${datasource.username}")
    private String PROPERTY_DATASOURCE_USERNAME;

    @Value("${datasource.password}")
    private String PROPERTY_DATASOURCE_PASSWORD;

    @Value("${datasource.driver-class-name}")
    private String PROPERTY_DATASOURCE_DRIVER;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(PROPERTY_DATASOURCE_DRIVER);
        dataSource.setUrl(PROPERTY_DATASOURCE_URL);
        dataSource.setUsername(PROPERTY_DATASOURCE_USERNAME);
        dataSource.setPassword(PROPERTY_DATASOURCE_PASSWORD);
        return dataSource;
    }

//    @Bean
//    public JtaTransactionManager transactionManager() {
//        return new JtaTransactionManager();
//    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

//    @Bean
//    public ManagedTransactionFactory managedTransactionFactory(){
//        return new ManagedTransactionFactory();
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setTransactionFactory(managedTransactionFactory());
        return sessionFactory.getObject();
    }
}
