package com.jdsk.people.configs;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jakarta.annotation.Priority;

@Configuration
@Priority(value = 1)
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
//
//    @Bean
//    MariadbConnectionFactory dataSource() {
//    	MariadbConnectionConfiguration conf = MariadbConnectionConfiguration.builder()
//                //.host("r2dbc:mariadb://192.168.1.17")
//    			.host("192.168.1.17")
//                .port(3306)
//                .username("adminpayments")
//                .password("payments$$")
//                .database("people")
//                .build();
//    MariadbConnectionFactory factory = new MariadbConnectionFactory(conf);
//
//        return factory;
//    }

}