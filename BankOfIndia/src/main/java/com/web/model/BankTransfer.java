	package com.web.model;
	
	public class BankTransfer {
		private long accNo;  
		private String name;
		private String password;
		private double amount;  
		private long targetAcc;
		
		public BankTransfer() {
			super();
		}
		public BankTransfer(long accNo, String name, String password, double amount, long targetAcc) {
			super();
			this.accNo = accNo;
			this.name = name;
			this.password = password;
			this.amount = amount;
			this.targetAcc = targetAcc;
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
		public long getTargetAcc() {
			return targetAcc;
		}
		public void setTargetAcc(long targetAcc) {
			this.targetAcc = targetAcc;
		}
		@Override
		public String toString() {
			return "BankTransfer [accNo=" + accNo + ", name=" + name + ", password=" + password + ", amount=" + amount
					+ ", targetAcc=" + targetAcc + "]";
		}
		
		
	}
