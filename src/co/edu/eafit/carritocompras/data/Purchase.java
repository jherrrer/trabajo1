package co.edu.eafit.carritocompras.data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import co.edu.eafit.carritocompras.data.util.ChangeStatusException;

public class Purchase {

	private Calendar date;
	private List<Product> products;
	private BigDecimal totalPrice;
	private String code;
	private Customer customer;
	private PurchaseStatus status;


	public PurchaseStatus getStatus() {
		return status;
	}

	public void setStatus(PurchaseStatus status) throws ChangeStatusException {
		if (status == PurchaseStatus.PENDING
				&& (this.status == null || this.status == PurchaseStatus.REJECTED)) {
			this.status = status;
		} else if (status == PurchaseStatus.APPROVED
				&& this.status == PurchaseStatus.PENDING) {
			this.status = status;
		} else if (status == PurchaseStatus.REJECTED
				&& this.status == PurchaseStatus.PENDING) {
			this.status = status;
		} else if (status == PurchaseStatus.CLOSED
				&& (this.status == PurchaseStatus.APPROVED || this.status == PurchaseStatus.REJECTED)) {
			this.status = status;
		} else {
			throw new ChangeStatusException();
		}

	}
	
	public void markAsReview() {
		this.status = PurchaseStatus.REVIEW;
	}

	public Purchase(Customer customer) {
		super();
		this.customer = customer;
		this.date = Calendar.getInstance();
		this.code = (int) (Math.random() * 1000000) + "";
	}

	public Calendar getDate() {
		return date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
