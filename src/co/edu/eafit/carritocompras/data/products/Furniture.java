package co.edu.eafit.carritocompras.data.products;

import java.math.BigDecimal;

import co.edu.eafit.carritocompras.data.Product;

public class Furniture extends Product {

	@Override
	public BigDecimal calculateDiscount() {
		return this.getPrice().multiply(new BigDecimal(0.1));
	}
	
	
	public Furniture(String code, String name, BigDecimal price) {
		setCode(code);
		setName(name);
		setPrice(price);
	}
	
}
