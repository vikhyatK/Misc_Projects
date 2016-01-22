package com.springcore.mytravel.util;

import java.util.Date;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "classpath:/applicationContext.properties")
public class ObjectFactory {
	// @Autowired
	private Environment env;

	@Value("${jdbc.driver.className}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUserName;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean
	@Qualifier("currentDate")
	public Date getCurrentDate() {
		return new Date();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DriverManagerDataSource initDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName(env.getProperty("jdbc.driver.className"));
		dataSource.setDriverClassName(jdbcDriver);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(jdbcUserName);
		dataSource.setPassword(jdbcPassword);
		return dataSource;
	}

	/*
	 * @Bean public DriverManagerDataSource initDataSource(){
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName(env.getProperty("jdbc.driver.className"));
	 * dataSource.setUrl(env.getProperty("jdbc.url"));
	 * dataSource.setUsername(env.getProperty("jdbc.username"));
	 * dataSource.setPassword(env.getProperty("jdbc.password")); return
	 * dataSource; }
	 */

}
