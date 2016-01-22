package com.mvc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mvc.bean.User;





public class LoginDAO extends HibernateDaoSupport {
	 User login;
		public User getLogin() {
			return login;
		}
		public void setLogin(User login) {
			System.out.println("in dao to set login");
			this.login = login;
		}
		public  boolean isValid(User l)
		{
			System.out.println("in isvalid");
			
			     //getHibernateTemplate().
			String name=l.getUserid();
			System.out.println(name+"    "+l);
			List o= getHibernateTemplate().find("from User l where l.userid = ?", name);
			
			User x=(User) o.get(0);
			//return true;
			
			//Login x=(Login)getHibernateTemplate().load("com.model.Login.class",l.getUsername());
		
		         if (x.getPassword().equals(l.getPassword()))
		         {
		        	 return true;
		         }
		         else 
		        	 return 
		        	 false;
		
		}
	
/*	public static User validateUser(String userid) {
		System.out.println("in dao :" +  userid);
		User u = new User();
		try {
			DBConnect db = DBConnect.getInstance();
			Connection c = db.getConnection();
			String query = "select UserId,Password,Role from user where UserId = ?";

			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			System.out.println("in validateuser of login dao");
			while (rs.next()) {
				
				System.out.println("in while rs");
				u.setUserid(userid);
				u.setPassword(rs.getString("Password"));
				u.setRole(rs.getString("Role"));
			}

			System.out.println("...........");
		
			return u;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}*/

}
