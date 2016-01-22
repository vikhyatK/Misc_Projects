package com.springcore.mytravel.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao extends AbstractDao {
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = getDataSource().getConnection();
		} catch (SQLException ex) {

		}
		return connection;
	}

}
