package com.pack.service;

import com.pack.model.Vendor;

public interface LoginService {
	public boolean checkLogin(Vendor a);
	public int getCount(Vendor a);
	public int incrementCount(Vendor a,int count);
	public int setZeroCount(Vendor a);
	public String getUsername(Vendor a);
	public String getContact(Vendor a);
	public String getAddress(Vendor a);
	public float getRating(Vendor a);
	
}
