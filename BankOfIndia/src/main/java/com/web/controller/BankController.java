package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.model.BankClose;
import com.web.model.BankEntity;
import com.web.model.BankModel;
import com.web.model.BankTransfer;
import com.web.service.BankServiceImp;

@Controller
public class BankController {
	@Autowired 
	BankServiceImp service;
	@RequestMapping("/home")
public String homePage() {
	return "home";
}
	@RequestMapping("/newAcc")
	public String newAcc() {
		return "addNew";
	}
	
	@RequestMapping("/register")
	public String saveAcc(BankEntity entity,double amount) {
		BankEntity save=service.saveAcc(entity, amount);
		return "success";
	}
	
	
	@RequestMapping("/Balance")
	public String balcheck() {
		return "v";
	}
	@RequestMapping("/checkBalsuccess")
	public String check(BankEntity bankEntity, @RequestParam long accNo,String name,String password,ModelMap model) {
		BankEntity data=service.checkBal(bankEntity, accNo, name, password);
		
		model.put("first", data);
		
		return "balance";
	}
	
	
	@RequestMapping("/Deposit")
	public String dep(ModelMap model) {
		BankModel ref = new BankModel();
		model.put("first", ref);
		return "d";
	}
	@RequestMapping("/depoBal")
	public String deposite(BankEntity bankEntity, @RequestParam long accNo,String name,String password,double amount,ModelMap model) {
		BankEntity newamount = service.deposite(bankEntity, accNo, name, password, amount, model);
		String message=null;
		if(newamount!=null) {
			message="deposite successfully";
		}
		else {
			message="acount is inactive";
		}
	//	model.put("sec", message);
		return "depositeSuccess";
				
	}
	@RequestMapping("/Withdraw")
	public String with(ModelMap model) {
		BankModel ref = new BankModel();
		model.put("withdraAmount", ref);
		return "w";
	}
	@RequestMapping("/withdraBal")
	public String withdra(BankEntity bankEntity, @RequestParam long accNo,String name,String password,double amount,ModelMap model) {
		BankEntity newamount = service.withdra(bankEntity, accNo, name, password, amount, model);
		String message=null;
		if(newamount!=null) {
			message="withdra successfully";
		}
		else {
			message=" withdra successfully .acount is inactive";
		}
	
		return "withdraSuccess";
				
	}
	
	@RequestMapping("/Transfer")
	public String changeAmount(ModelMap model) {
		BankTransfer ref = new BankTransfer();
		model.put("trans", ref);
		return "t";
	}
	@RequestMapping("/transBal")
	public String tran(BankEntity bankEntity, @RequestParam long accNo,String name,String password,double amount, long targetAcc, ModelMap model) {
		BankEntity tmoney = service.transfer(bankEntity, accNo, name, password, amount, targetAcc);
	
		if(tmoney!=null) 
		{
			model.put("status", tmoney);
			
			return "transferSuccess";
					
		
		}
		else 
		{
			return " redirect:/transBal";
		}	}
	@RequestMapping("/closeUrl")
	public String closeAccount(ModelMap model,BankClose close){
		BankClose bankclosemodel=new BankClose();
		model.put("key", bankclosemodel);
		   return "c";
	  
		}
	@RequestMapping("/closeaccount")
		public String closeAccount(BankClose close,BankEntity entity,@RequestParam long accNo, String name, String password,ModelMap model) {
		BankEntity bobcloseAcc=service.closeAcc(close,entity,accNo,name,password);
		 String message=null;
		 if(bobcloseAcc!=null) {
		  message="Your account closed successfully"; 
		  }
		 else { 
			 message="You have entered invalid";	
		 }
		 return "closeSuccess";
		 }
	
}
