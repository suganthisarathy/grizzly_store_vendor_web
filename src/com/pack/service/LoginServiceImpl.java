package com.pack.service;

import com.pack.dao.LoginDaoImpl;
import com.pack.model.Vendor;

public class LoginServiceImpl implements LoginService {

	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkLogin(Vendor a) {
		// TODO Auto-generated method stub
		boolean value= new LoginDaoImpl().checkLogin(a);
		return value;
	}

	@Override
	public int getCount(Vendor a) {
		// TODO Auto-generated method stub
		int count=new LoginDaoImpl().getCount(a);
		return count;
	}

	@Override
	public int incrementCount(Vendor a, int count) {
		// TODO Auto-generated method stub
		int j=new LoginDaoImpl().incrementCount(a,count);
		return j;
	}

	@Override
	public int setZeroCount(Vendor a) {
		// TODO Auto-generated method stub
		int count=new LoginDaoImpl().setZeroCount(a);
		return count;
	}

	@Override
	public String getUsername(Vendor a) {
		// TODO Auto-generated method stub
		String username= new LoginDaoImpl().getUsername(a);
		return username;
	}

	@Override
	public String getContact(Vendor a) {
		// TODO Auto-generated method stub
		String designation=new LoginDaoImpl().getContact(a);
		return designation;
	}

	@Override
	public String getAddress(Vendor a) {
		// TODO Auto-generated method stub
		String office=new LoginDaoImpl().getAddress(a);
		return office;
	}

	@Override
	public float getRating(Vendor a) {
		// TODO Auto-generated method stub
		float rating=new LoginDaoImpl().getRating(a);
		return rating;
	}

	
	
}
