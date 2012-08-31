package co.edu.eafit.carritocompras.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Product;
import co.edu.eafit.carritocompras.data.Purchase;
import co.edu.eafit.carritocompras.data.PurchaseStatus;
import co.edu.eafit.carritocompras.data.util.ChangeStatusException;

public class BillingCalculator {

	/**
	 * @param productsFlatFile
	 *            Comma-separated codes of products (e.g. code1, code2, code3)
	 * 
	 *            Postcondition: totalPrice attribute is updated with the
	 *            totalAmount of prices of products included
	 */
	public static Purchase calculateTotalPurchase(Customer customer, String productsFlatFile) {
		Purchase purchase = new Purchase(customer);
		List<Product>products = new ArrayList<Product>();
		BigDecimal total = BigDecimal.ZERO;
		for (String code : productsFlatFile.split(",")) {
			Product p = Product.buildProduct(code);
			total = total.add(p.getPrice());
			total = total.subtract(p.calculateDiscount());
			products.add(p);
		}
		
		purchase.setProducts(products);
		purchase.setTotalPrice(total);
		try {
			purchase.setStatus(PurchaseStatus.PENDING);
		} catch (ChangeStatusException e) {
			throw new RuntimeException("Error setting pending status");
		}
		
		return purchase;
	}
}
