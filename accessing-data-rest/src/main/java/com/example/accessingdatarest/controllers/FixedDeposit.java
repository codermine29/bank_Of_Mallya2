package com.example.accessingdatarest.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
public class FixedDeposit {
	
	@Autowired
	private DepositAmount depositAmount;
	
	
	@Autowired
	private AccountNumber accountNumber;
	
	
	@Autowired
	private TimeDuration timeDuration;
	
	
	@Autowired
	private Interest interest;
	
	public void setDepositAmount(DepositAmount depositAmount)
	{
		this.DepositAmount = depositAmount;
	}
	
	public void setAccountNumber(AccountNumber accountNumber) 
	{
		this.AccountNumber = accountNumber;
	}
	
	public void setFixedDepositSupport(FixedDepositSupport fixedDepositSupport)
	{
		this.fixedDepositSupport = fixedDepositSupport;
	}
	
	public ResponseEntity<FixedDepositHolders> getFixedDepositDetails(@PathVariable int fdh_id)
	{
		try
		{
			return new ResponseEntity<>(this.fixedDepositHoldersService.getFixedDepositHolders(fdh_id).get(),HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity("Fixed Deposit Holder details are not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/addFixedDeposit/customerid/{cust_id}/amount/{amount}/duration/{duration}/roi/{roi}")
	public ResponseEntity<String> addFixedDeposit(@PathVariable int cust_id,@PathVariable double amount,@PathVariable int duration,@PathVariable int roi)
	{
		try
		{
			Customer customer = fixedDepositSupport.getCustomerDetails(cust_id);
			if(customer!=null)
			{
				FixedDeposits fixedDeposits = new FixedDeposits();
				FixedDepositHolders fixedDepositHolders = new FixedDepositHolders();
				fixedDeposits.setDepositDuration(duration);
				fixedDeposits.setRateOfInterest(roi);
				fixedDepositsService.insertFixedDeposit(fixedDeposits);
				fixedDepositHolders.setAmount(amount);
				fixedDepositHolders.setCustomer(customer);
				fixedDepositHolders.setDepositDetails(fixedDeposits);
				fixedDepositHolders.setDepositedDate(LocalDate.now());
				if(fixedDepositHoldersService.insertFixedDepositHolders(fixedDepositHolders)!= null)
					return new ResponseEntity<>("Successful",HttpStatus.OK);
				else
					return new ResponseEntity<>("Failed",HttpStatus.NOT_ACCEPTABLE);
			}
			else
				throw new NoSuchElementException();
			}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>("Customer Id does not exist",HttpStatus.NOT_FOUND);
		
		}
		}
	
	
	 @GetMapping("/getAllFixedDepositHolders") 
	 public List<FixedDepositHolders>getAllFixedDepositHolders() { 
		 return fixedDepositHoldersService.getAllFixedDepositHolders();
				 }
	
}
*/
