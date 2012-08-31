package co.edu.eafit.carritocompras.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import co.edu.eafit.carritocompras.data.products.ElectronicProduct;
import co.edu.eafit.carritocompras.data.products.Furniture;

public abstract class Product {

	private String code;
	private String name;
	private BigDecimal price;

	private static final Map<String, BigDecimal> productPricesBD;
	
	static {
		productPricesBD = new HashMap<String, BigDecimal>();
		for (int i = 1; i < 6; i++) {
			productPricesBD.put("EL-00"+i, new BigDecimal(Math.random()*100000));
			productPricesBD.put("FU-00"+(i+5), new BigDecimal(Math.random()*1000000));
		}
		
	}
	
	public abstract BigDecimal calculateDiscount();
	
	public static Product buildProduct(String code) {
		if (productPricesBD.get(code) == null) {
			throw new IllegalArgumentException("Product does not exist. Products are EL-001 through EL-005 and FU-006 through FU-0010");
		}
		
		if (code.startsWith("EL")) {
			return new ElectronicProduct(code, "Electronic_"+code, productPricesBD.get(code));
		} else if (code.startsWith("FU")) {
			return new Furniture(code, "Furniture_"+code, productPricesBD.get(code));
		}
		
		throw new IllegalArgumentException("Code does not start with EL or FU");
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public static Map<String, BigDecimal> getProductPricesBD() {
		return productPricesBD;
	}

}
