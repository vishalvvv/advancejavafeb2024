package com.digitallync.springdi_demo;

public class Customer {
	
	private String name;
	private String adhaar;
	private long mobile;
	private Account account;
	public Customer(String name, String adhaar, long mobile, Account account) {
		super();
		this.name = name;
		this.adhaar = adhaar;
		this.mobile = mobile;
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public String getAdhaar() {
		return adhaar;
	}
	public long getMobile() {
		return mobile;
	}
	public Account getAccount() {
		return account;
	}
	
}
