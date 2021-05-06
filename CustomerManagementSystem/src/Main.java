
import java.rmi.RemoteException;


import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.util.GregorianCalendar;

import adapters.MernisServiceAdapter;
import entities.Customer;
import interfaces.CustomerCheckService;
import interfaces.CustomerService;
import services.StarbucksCustomerCheckManager;
import services.StarbucksCustomerManager;



public class Main {

	
	public static void main(String[] args) throws RemoteException {
		
	
	
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(
				Long.parseLong("99999999999"), 
				"SAMET", 
				"AKCA", 
				1999
				);
	
		System.out.println(" ---------------- MERNÝS TC DOÐRULAMA ---------------- ");
		
		System.out.println(" Mernis Tc Doðrulama :  " + (result ? " Baþarýlý  " : " Hatalý "));
		
		
		
	
		Customer enginCustomer = new Customer();
		enginCustomer.setId(1);
		enginCustomer.setIdentityNumber("000000000000");
		enginCustomer.setFirstName("Karcan");
		enginCustomer.setLastName("Özbal");
		//enginCustomer.setBirthDate(new GregorianCalendar(1993, 11 , 16).getTime());
		
		CustomerCheckService customerCheckService = new StarbucksCustomerCheckManager(new MernisServiceAdapter());
		
		CustomerService customerService = new StarbucksCustomerManager(customerCheckService);
		customerService.add(enginCustomer);
		
		
		}
	
		
	}


