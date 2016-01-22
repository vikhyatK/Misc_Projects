package com.mvc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	static DBConnect db;

	private DBConnect() {

	}

	public static DBConnect getInstance() {
		if (db == null) {
			db = new DBConnect();
			return db;
		}
		return db;
	}

	public Connection getConnection() {
		Connection conn;
		conn = null;
	    String url = "jdbc:mysql://localhost:3306/inventorycontrol";
	    String driver = "com.mysql.jdbc.Driver";
		try {

			Class.forName(driver);
	        conn = DriverManager.getConnection(url,"root","root");
	        System.out.println("1sdfsdv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("1sdfsdv");
		return conn;
	}
}
