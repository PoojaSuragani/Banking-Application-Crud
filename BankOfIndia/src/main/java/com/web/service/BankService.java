package com.web.service;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.model.BankClose;
import com.web.model.BankEntity;

public interface BankService {
	public BankEntity saveAcc(BankEntity entity, double amount);
	public BankEntity checkBal(BankEntity entity, @RequestParam long accNo,String name,String password);
	public BankEntity deposite(BankEntity entity, @RequestParam long accNo,String name,String password ,double amount,ModelMap model);
	public BankEntity withdra(BankEntity entity, @RequestParam long accNo,String name,String password ,double amount,ModelMap model);
	public BankEntity transfer(BankEntity entity, @RequestParam long accNo,String name,String password ,double amount,long targetAcc);
	public BankEntity closeAcc(BankClose close, BankEntity entity, @RequestParam long accNo,String name,String password);
	
	
}
