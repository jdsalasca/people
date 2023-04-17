package com.jdsk.people.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jakarta.annotation.Priority;

@Configuration
@Priority(value = 1)
public class DataSourceConfig {

	private static final String URL = System.getenv("DATASOURCE_URL");
	private static final String DRIVERCLASSNAME = System.getenv("DATASOURCE_DRIVER_CLASS_NAME");
	private static final String USERNAME = System.getenv("DATASOURCE_USERNAME");
	private static final String PASSWORD = System.getenv("DATASOURCE_PASSWORD");

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVERCLASSNAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

}