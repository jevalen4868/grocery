package com.heb.j01.grocery.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.heb.j01.grocery.repository", "com.heb.j01.grocery.services"})
public class DataConfig {
    private static final Logger LOGGER = LogManager.getLogger(DataConfig.class);

    @Bean
    public DataSource groceryDataSource() throws Exception {
        LOGGER.info("Configuring dataSourceBean.");
        Properties dsProperties = new Properties();
        dsProperties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        dsProperties.setProperty("username", "grocery");
        dsProperties.setProperty("password", "password");
        dsProperties.setProperty("url", "jdbc:mysql://localhost:3306/grocery_db?serverTimezone=UTC");
        DataSource ds = BasicDataSourceFactory.createDataSource(dsProperties);
        return ds;
    }
}
