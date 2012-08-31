package co.edu.eafit.carritocompras.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.mockito.Mockito;
import org.junit.Test;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Product;
import co.edu.eafit.carritocompras.data.Purchase;
import co.edu.eafit.carritocompras.data.products.ElectronicProduct;

public class BillingCalculatorTest {
	private Customer customer;

	
	@Before
	public void setUp() {
		customer = new Customer("xx1", "xxName");

	}
	@Test
	public void testCalculateTotalPurchase() {
		
		Map<String, BigDecimal> mp= Product.getProductPricesBD();
		Purchase p = BillingCalculator.calculateTotalPurchase(customer, "EL-001,FU-007");
		
		//Mocking external service behavior
		
	   
		assertEquals("total",mp.get("EL-001").subtract(mp.get("EL-001").multiply(new BigDecimal(0.2))).add(mp.get("FU-007").subtract(mp.get("FU-007").multiply(new BigDecimal(0.1)))),p.getTotalPrice());
	}

}
