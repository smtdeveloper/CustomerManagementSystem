package abstracts;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import entities.Customer;
import interfaces.CustomerCheckService;
import interfaces.Result;

public   class CustomerCheckManager implements CustomerCheckService {

	@Override
	public Result CheckIfRealPerson(Customer customer) {
		
		return new utils.Result(true);
	}

	

	
	@Override
	public final Result CheckIfYoungerAgeThan(Customer customer, int age) {
		LocalDate todayDateTime = LocalDate.now();
		LocalDate birthDate = customer.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int yearDifference = Period.between(birthDate, todayDateTime).getYears();
		if(yearDifference < age) {
		return new utils.Result(false, age + " yaþýndan küçük olamaz.");
		}
		return new utils.Result(true);
	}
	
}
