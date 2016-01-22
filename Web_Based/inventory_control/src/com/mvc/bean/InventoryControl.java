package com.mvc.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.connection.DBConnect;

public class InventoryControl {
	
	public static void CheckUser()
	{
		
		
	}
	
	public static ArrayList<Product> ViewAllOkProducts()
	{
		ArrayList<Product> l=new ArrayList<Product>();
		Product p = null;
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn = DBConnect.getInstance().getConnection();
			pst = conn.prepareStatement("select * from product where ProductStatus='OK'");
			
			ResultSet rst = pst.executeQuery();
			System.out.println(rst.toString());
			
			if (rst.next()) {
				p = new Product();
				p.setId(rst.getInt(1));
				p.setName(rst.getString(2));
				p.setPrice(rst.getInt(3));
				p.setQuantity(rst.getInt(4));
				p.setStatus(rst.getString(5));
				l.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pst!=null)
			{
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return l;
		
	}
}
