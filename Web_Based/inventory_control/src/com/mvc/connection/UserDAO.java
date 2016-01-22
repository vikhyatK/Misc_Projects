package com.mvc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.User;

public class UserDAO {
	static Connection c = null;
	
	public static int registerCustomer(User c1){
		try {
			DBConnect db = DBConnect.getInstance();
			c = db.getConnection();
			String sql="insert into user values (?,?,?,?,?)";
			
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, c1.getUserid());
			ps.setString(2,c1.getName());
			ps.setString(3,c1.getPassword());
			ps.setInt(4,c1.getPhone());
			ps.setString(5,c1.getRole());
			
			int count=ps.executeUpdate();
			return count;
		    } 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
}
}
