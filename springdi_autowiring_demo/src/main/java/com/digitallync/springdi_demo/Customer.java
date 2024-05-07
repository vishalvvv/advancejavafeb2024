package com.digitallync.springdi_demo;

public class Customer {
	
	private String name;
	private String adhaar;
	private long mobile;
	private Account xyz;
	
	
	
	
	public Account getXyz() {
		return xyz;
	}
	public void setXyz(Account xyz) {
		this.xyz = xyz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	

}
