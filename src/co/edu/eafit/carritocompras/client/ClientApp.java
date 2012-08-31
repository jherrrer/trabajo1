package co.edu.eafit.carritocompras.client;

import java.util.ArrayList;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;
import co.edu.eafit.carritocompras.service.BillingCalculator;
import co.edu.eafit.carritocompras.service.GenericCreditCardService;
import co.edu.eafit.carritocompras.service.PaymentService;

public class ClientApp {

	public static void main(String[] args) {
		Customer customer1 = new Customer("1", "John Doe");
		
		Purchase purchase = BillingCalculator.calculateTotalPurchase(customer1,
				"EL-001,EL-004,FU-007");
		if (customer1.getPurchases() == null) {
			customer1.setPurchases(new ArrayList<Purchase>());
		}
		customer1.getPurchases().add(purchase);
		
		//pay purchase
		new PaymentService().pay(customer1, purchase, "11112222", new GenericCreditCardService());
	}

}
