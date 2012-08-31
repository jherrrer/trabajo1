package co.edu.eafit.carritocompras.data.products;

import java.math.BigDecimal;

import co.edu.eafit.carritocompras.data.Product;

public class ElectronicProduct extends Product {

	@Override
	public BigDecimal calculateDiscount() {
		return this.getPrice().multiply(new BigDecimal(0.2));
	}

	public ElectronicProduct(String code, String name, BigDecimal price) {
		setCode(code);
		setName(name);
		setPrice(price);
	}
	
}
