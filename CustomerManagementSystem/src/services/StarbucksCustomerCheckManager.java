package services;

import abstracts.CustomerCheckManager;
import entities.Customer;
import interfaces.RealPersonService;
import interfaces.Result;

public class StarbucksCustomerCheckManager  extends CustomerCheckManager {
 
private RealPersonService realPersonService;
	
	public StarbucksCustomerCheckManager(RealPersonService realPersonService){
		this.realPersonService = realPersonService;
	}
	
	@Override
	public Result CheckIfRealPerson(Customer customer) {
		
		return realPersonService.CheckIfRealPerson(customer);
	}
}
