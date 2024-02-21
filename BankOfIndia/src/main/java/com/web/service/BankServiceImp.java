																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.web.model.BankClose;
import com.web.model.BankEntity;
import com.web.repo.bankRepo;

@Service
public class BankServiceImp implements BankService {
	@Autowired 
	public bankRepo repo;
	@Override
	public BankEntity saveAcc(BankEntity entity, double amount) {
		double preBal=0;
		double cruBal=amount;
		entity.setPreBal(preBal);
		entity.setCruBal(cruBal);
		String status ="active";
		entity.setStatus(status);
		
	
		return repo.save(entity) ;
	}
	@Override
	public BankEntity checkBal(BankEntity entity, long accNo, String name, String password) {
		BankEntity oneAcc=repo.findById(accNo).get();
		if (name.equals(entity.getName())&&password.equals(entity.getPassword())) {
			return oneAcc;
		}
		else {
			return null;
		}
	}
	@Override
	public BankEntity deposite(BankEntity entity, long accNo, String name, String password, double amount,ModelMap model) {
		BankEntity oneAcc=repo.findById(accNo).get();
		if (oneAcc.getStatus().equals("active")) {
			
		
			if (name.equals(oneAcc.getName())&&password.equals(oneAcc.getPassword())) {
				double preBal=oneAcc.cruBal;
				double cruBal= oneAcc.getCruBal()+amount;
				oneAcc.setPreBal(preBal);
				oneAcc.setCruBal(cruBal);
				
			}
		}
		
		BankEntity savenew=repo.save(oneAcc);
		return savenew;
		
	}
	@Override
	public BankEntity withdra(BankEntity entity, long accNo, String name, String password, double amount,
			ModelMap model) {
		BankEntity  withdraOne =repo.findById(accNo).get();
		if (withdraOne.getStatus().equals("active")) {
			if (name.equals(withdraOne.getName())&&password.equals(withdraOne.getPassword())) {
				double pBal =withdraOne.cruBal;
				double cBal =withdraOne.getCruBal()-amount;
				withdraOne.setPreBal(pBal);
				withdraOne.setCruBal(cBal);
		}
		
	}
		BankEntity savenew=repo.save(withdraOne);
		return savenew;
	}
	@Override
	public BankEntity transfer(BankEntity entity, long accNo, String name, String password, double amount,long targetAcc) {
			
		BankEntity  transfer =repo.findById(accNo).get();
		BankEntity transfer1 =repo.findById(targetAcc).get();
		
		
		if (transfer.getStatus().equals("active")) {
			
			if (transfer.getAccNo()==(accNo)&& transfer1.getAccNo()==(targetAcc)) {
		
				double cBal =transfer.getCruBal();
				 double v = cBal -amount;
				double targetBal =transfer1.getCruBal();
				double h =targetBal+amount;
				BankEntity transfer2=new BankEntity();
				
				transfer.setCruBal(v);
				transfer1.setCruBal(h);

				transfer2 =repo.save(transfer);
				transfer2 =repo.save(transfer1);
				
				System.out.println(transfer1);
				System.out.println(transfer2);
				
				return transfer2;
				
				
			}}
	return null;
	}
	@Override
	public BankEntity closeAcc(BankClose close, BankEntity entity, long accNo, String name, String password) {
		BankClose accclose=new BankClose();
		BankEntity entity1=repo.findById(accNo).get(); 
		
		  if(accNo==entity1.getAccNo()&&name.equals(entity1.getName())&&password.equals(entity1.getPassword())) {
			  String status="Inactive";
			   entity1.setStatus(status); 
			   return  repo.save(entity1);
			  }
		  
		else { 
				return null;
		  }
	}
	
}	
