package com.pack.model;

public class Vendor {

	public Vendor() {
		// TODO Auto-generated constructor stub
	}
private int userid;
private String username;
private String password;
private float rating;
private String contact;
private String address;
private int count;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Vendor(int userid, String password, int count) {
	super();
	this.userid = userid;
	this.password = password;
	this.count = count;
}
public Vendor(int userid, String password) {
	super();
	this.userid = userid;
	this.password = password;
}
}
