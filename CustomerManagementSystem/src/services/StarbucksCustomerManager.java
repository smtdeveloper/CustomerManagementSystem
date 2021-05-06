package services;

import abstracts.CustomerManager;
import entities.Customer;
import interfaces.CustomerCheckService;
import interfaces.Result;
import utils.CheckServiceUtils;

public class StarbucksCustomerManager  extends CustomerManager {

	private CustomerCheckService customerCheckService;
	
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}


	@Override
	public void add(Customer customer) {

		Result result =  CheckServiceUtils.runCheckServices(new Result[] {
				customerCheckService.CheckIfRealPerson(customer), 
				customerCheckService.CheckIfYoungerAgeThan(customer, 15)
				});
		
		if(!result.isSuccess()) {
			System.out.println(result.getMessage());
			return;
		}
		
		super.add(customer);
	}
	
}
