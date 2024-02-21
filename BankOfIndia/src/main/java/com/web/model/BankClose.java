package com.web.model;

public class BankClose {
	public long accNo; 
	public String name; 
	public String password;
	public BankClose() {
		super();
	}
	public BankClose(long accNo, String name, String password) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.password = password;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BankClose [accNo=" + accNo + ", name=" + name + ", password=" + password + "]";
	} 
	

}
