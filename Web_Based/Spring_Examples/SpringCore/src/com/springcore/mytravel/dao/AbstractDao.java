package com.springcore.mytravel.dao;

import java.sql.Connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class AbstractDao {
	DriverManagerDataSource dataSource;

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public abstract Connection getConnection();
}
