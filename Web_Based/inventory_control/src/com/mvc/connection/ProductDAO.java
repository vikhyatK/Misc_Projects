package com.mvc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mvc.bean.Product;
import com.mvc.bean.User;


public class ProductDAO extends HibernateDaoSupport{
	 static Connection conn = null;

	 Product pd1;
	 
		public Product getPd1() {
		return pd1;
	}
	public void setPd1(Product pd1) {
		System.out.println("in product login dao.....");
		this.pd1 = pd1;
	}
		
		@SuppressWarnings("unchecked")
		public  List<Product> selectOKProduct()
		{
			System.out.println("in selectOKProduct");
			
			     //getHibernateTemplate().
			String name="OK";

			List<Product> o= getHibernateTemplate().find("from Product l where l.status = ?", name);
			
			return o;
		
		}
/*	public static ArrayList<Product> selectOKProduct() {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn = DBConnect.getInstance().getConnection();

			pst = conn.prepareStatement("select * from product where ProductStatus = ? ");
			
			pst.setString(1, "OK");

			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				Product cmp=new Product();
				cmp.setId(rst.getInt("ProductId"));
				cmp.setName(rst.getString("ProductName"));
				cmp.setPrice(rst.getInt("ProductPrice"));
				cmp.setQuantity(rst.getInt("ProductQuantity"));
				result.add(cmp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
				if(pst!=null)
				{
					pst.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}*/
		  @SuppressWarnings("unchecked")
		public List<Product> selectDamagedProduct() {
		System.out.println("in selectDamagedProduct");
		
	     //getHibernateTemplate().
	    String name="DAMAGED";
	    	System.out.println(name);
	     
			List<Product> o= getHibernateTemplate().find("from Product l where l.status = ?", name);
	        System.out.println(name);
			return o;
		}
	/*public static List<Product> selectDamagedProduct() {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn = DBConnect.getInstance().getConnection();

			pst = conn.prepareStatement("select * from product where ProductStatus = ? ");
			
			pst.setString(1, "DAMAGED");

			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				Product cmp=new Product();
				cmp.setId(rst.getInt("ProductId"));
				cmp.setName(rst.getString("ProductName"));
				cmp.setPrice(rst.getInt("ProductPrice"));
				cmp.setQuantity(rst.getInt("ProductQuantity"));
				result.add(cmp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
				if(pst!=null)
				{
					pst.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}*/
	public List<Product> selectRequiredProduct() {
		System.out.println("in selectRequiredProduct");
		
	     //getHibernateTemplate().
	    String name="OK";
	    	System.out.println(name);
	     int quant=4;
			@SuppressWarnings("unchecked")
			List<Product> o= getHibernateTemplate().find("from Product l where l.status = ? and quantity<=?", name,quant);
	        System.out.println(name);
			return o;
	}
	/*
	public static ArrayList<Product> selectRequiredProduct() {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn = DBConnect.getInstance().getConnection();

			pst = conn.prepareStatement("select * from product where ProductQuantity <= 4 and ProductStatus !=?");
			
			pst.setString(1, "DAMAGED");
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				Product cmp=new Product();
				cmp.setId(rst.getInt("ProductId"));
				cmp.setName(rst.getString("ProductName"));
				cmp.setPrice(rst.getInt("ProductPrice"));
				cmp.setQuantity(rst.getInt("ProductQuantity"));
				result.add(cmp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
				if(pst!=null)
				{
					pst.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	*/
	
	public List<Product> placeOrder(){
		System.out.println("in place order");
		String name="OK";
		int quant=4;
		@SuppressWarnings("unchecked")
		List<Product> o=  getHibernateTemplate().find("from Product l where l.status = ? and l.quantity<=?", name,quant);
        
		System.out.println(o);
		for (Product product : o) {
			int i=product.getQuantity()+10;
			product.setQuantity(i);
			System.out.println("quantity : "+product.getQuantity());
			getHibernateTemplate().update(product);	
		}
			
			@SuppressWarnings("unchecked")
			List<Product> result=getHibernateTemplate().find("from Product l where l.status=?",name);
			System.out.println("1           "+result);
			return result;
	}
	/*public static ArrayList<Product> placeOrder() {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		int s=0;
		try {
			conn = DBConnect.getInstance().getConnection();

			pst = conn.prepareStatement("update product set ProductQuantity= (ProductQuantity+10) where ProductQuantity <= 4 and ProductStatus !=? ");
			
			pst.setString(1, "DAMAGED");
			 s= pst.executeUpdate();
			 System.out.println(s);
			if(s!=0)
			{
				pst = conn.prepareStatement("select * from product");
				
				
				ResultSet rst = pst.executeQuery();
				while(rst.next()){
					Product cmp=new Product();
					cmp.setId(rst.getInt("ProductId"));
					cmp.setName(rst.getString("ProductName"));
					cmp.setPrice(rst.getInt("ProductPrice"));
					cmp.setQuantity(rst.getInt("ProductQuantity"));
					result.add(cmp);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
				if(pst!=null)
				{
					pst.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	*/
	public List<Product> updatePrice(Product p){
		System.out.println("in selectDamagedProduct");
		String name="DAMAGED";
		int id=p.getId();
		@SuppressWarnings("unchecked")
		List<Product> o=  getHibernateTemplate().find("from Product l where l.status = ? and l.id=?", name,id);
        
		System.out.println(name);
		for (Product product : o) {
			p.setQuantity(product.getQuantity());
			
		}
		p.setStatus("OK");	
			getHibernateTemplate().update(p);
			@SuppressWarnings("unchecked")
			List<Product> result=getHibernateTemplate().find("from Product l");
			
			System.out.println(name);
			return result;
	}
	/*public static ArrayList<Product> updatePrice(int id,String name,int price) {
		ArrayList<Product> result = new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		int s=0;
		try {
			conn = DBConnect.getInstance().getConnection();
			
			pst = conn.prepareStatement("update product set ProductName=?,ProductPrice=? where ProductId = ? ");
			System.out.println(name+price+id);
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.setInt(3, id);
			 s= pst.executeUpdate();
			 System.out.println("value "+s);
			if(s!=0)
			{
				pst = conn.prepareStatement("select * from product");
				
				
				ResultSet rst = pst.executeQuery();
				while(rst.next()){
					Product cmp=new Product();
					cmp.setId(rst.getInt("ProductId"));
					cmp.setName(rst.getString("ProductName"));
					cmp.setPrice(rst.getInt("ProductPrice"));
					result.add(cmp);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
				if(pst!=null)
				{
					pst.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}*/
}
