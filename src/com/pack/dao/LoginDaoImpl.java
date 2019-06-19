package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pack.JdbcConnection;
import com.pack.model.Vendor;

public class LoginDaoImpl implements LoginDao {

	public LoginDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public  boolean checkLogin(Vendor a) {
		// TODO Auto-generated method stub
		Connection con=null;
		boolean val=false;
		try
		{
			System.out.println("ado impl");
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select userid,password from vendor where userid=? and password=?");
			ps.setInt(1, a.getUserid());
			ps.setString(2, a.getPassword());
			ResultSet rs=ps.executeQuery();
			System.out.println(rs);
			if(rs.next())
			{
				System.out.println("hello");
				val=true;
			}
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		return val;
	}


	@Override
	public int getCount(Vendor a) {
		// TODO Auto-generated method stub
		int count=0;
		Connection con=null;
		try
		{
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select count from vendor where userid=?");
			ps.setInt(1,a.getUserid());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return count;
	}


	@Override
	public int incrementCount(Vendor a, int count) {
		// TODO Auto-generated method stub
		Connection con=null;
		int c=0;
		try
		{
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update  vendor set count=? where userid=?");
			ps.setInt(1,count+1);
			ps.setInt(2, a.getUserid());
			 c=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return c;
	}


	@Override
	public int setZeroCount(Vendor a) {
		// TODO Auto-generated method stub
		Connection con=null;
		int c=0;
		try
		{
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update  vendor set count=0 where userid=?");
			ps.setInt(1, a.getUserid());
			 c=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return c;
		
	}
	public String getUsername(Vendor a) {
        // TODO Auto-generated method stub
        Connection con=null;
        String username=null;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("select username from vendor where userid=? and password=?");
               ps.setInt(1, a.getUserid());
               ps.setString(2, a.getPassword());
               ResultSet rs=ps.executeQuery();
               if(rs.next())
               {
                     username=rs.getString(1);
               }
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
        return username;
 }


	@Override
	public String getContact(Vendor a) {
		// TODO Auto-generated method stub
		 Connection con=null;
	        String contact=null;
	        try
	        {
	               con=JdbcConnection.getConnection();
	               PreparedStatement ps=con.prepareStatement("select contact from vendor where userid=? ");
	               ps.setInt(1, a.getUserid());
	               ResultSet rs=ps.executeQuery();
	               if(rs.next())
	               {
	                     contact=rs.getString(1);
	               }
	        }
	        catch(Exception e)
	        {
	               System.out.println(e);
	        }
	        
	        return contact;
	        
	}


	@Override
	public String getAddress(Vendor a) {
		// TODO Auto-generated method stub
		Connection con=null;
        String address=null;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("select address from vendor where userid=? ");
               ps.setInt(1, a.getUserid());
               ResultSet rs=ps.executeQuery();
               if(rs.next())
               {
                     address=rs.getString(1);
               }
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
       
		
        return address;
	}


	@Override
	public float getRating(Vendor a) {
		// TODO Auto-generated method stub
		Connection con=null;
        float rating=0;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("select rating from vendor where userid=? ");
               ps.setInt(1, a.getUserid());
               ResultSet rs=ps.executeQuery();
               if(rs.next())
               {
                     rating=rs.getFloat(1);
               }
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
        System.out.println(rating);
	
        return rating;
		
	}


	
		


}
