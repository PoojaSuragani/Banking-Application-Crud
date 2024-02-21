	package com.web.model;
	
	public class BankModel {
		private long accNo;  
		private String name;
		private String password;
		private double amount;  
		private String addr;
		private String mobileNo;
		public BankModel() {
			super();
		}
		public BankModel(long accNo, String name, String password, double amount, String addr, String mobileNo) {
			super();
			this.accNo = accNo;
			this.name = name;
			this.password = password;
			this.amount = amount;
			this.addr = addr;
			this.mobileNo = mobileNo;
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
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		@Override
		public String toString() {
			return "BankModel [accNo=" + accNo + ", name=" + name + ", password=" + password + ", amount=" + amount
					+ ", addr=" + addr + ", mobileNo=" + mobileNo + "]";
		}
	
	}
