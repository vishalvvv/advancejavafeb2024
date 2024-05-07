package com.digitallync.springdi_demo;

public class Account {
	
	private String accountId; //ACC12345
	private long balance;
	private String customerId;   //sbi89899
	public Account(String accountId, long balance, String customerId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customerId = customerId;
	}
	public String getAccountId() {
		return accountId;
	}
	public long getBalance() {
		return balance;
	}
	public String getCustomerId() {
		return customerId;
	}
	

}
