package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "bankTable")
public class BankEntity {

	@Id
	private long accNo;  
	private String name;
	private String password;
	private double preBal;
	public double cruBal;
	private String addr;
	private long mobileNo;
	private String status;
	public BankEntity() {
		super();
	}
	public BankEntity(long accNo, String name, String password, double preBal, double cruBal, String addr,
			long mobileNo, String status) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.password = password;
		this.preBal = preBal;
		this.cruBal = cruBal;
		this.addr = addr;
		this.mobileNo = mobileNo;
		this.status = status;
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
	public double getPreBal() {
		return preBal;
	}
	public void setPreBal(double preBal) {
		this.preBal = preBal;
	}
	public double getCruBal() {
		return cruBal;
	}
	public void setCruBal(double cruBal) {
		this.cruBal = cruBal;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankEntity [accNo=" + accNo + ", name=" + name + ", password=" + password + ", preBal=" + preBal
				+ ", cruBal=" + cruBal + ", addr=" + addr + ", mobileNo=" + mobileNo + ", status=" + status + "]";
	}
	
	

}
