package abstracts;
	
import entities.Customer;
import interfaces.CustomerService;

public  class CustomerManager implements CustomerService {

	@Override
	public  void add(Customer customer) {
		System.out.println(customer.getFirstName() + " ba�ar�l� bir �ekilde kaydedildi.");
		
	}

}
