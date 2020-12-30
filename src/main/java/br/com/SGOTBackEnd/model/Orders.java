package br.com.SGOTBackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "product1", nullable = false)
	private Product product1;
	@Column(name = "product2", nullable = true)
	private Product product2 = null;
	@Column(name = "product3", nullable = true)
	private Product product3 = null;
	@Column(name = "totalValue")
	private double totalValue;
	
	
	public Orders() {
		super();
	}
	public Orders(long id, Product product1, Product product2, Product product3, double totalValue) {
		super();
		this.id = id;
		this.product1 = product1;
		this.product2 = product2;
		this.product3 = product3;
		this.totalValue = totalValue;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct1() {
		return product1;
	}
	public void setProduct1(Product product1) {
		this.product1 = product1;
	}
	public Product getProduct2() {
		return product2;
	}
	public void setProduct2(Product product2) {
		this.product2 = product2;
	}
	public Product getProduct3() {
		return product3;
	}
	public void setProduct3(Product product3) {
		this.product3 = product3;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
