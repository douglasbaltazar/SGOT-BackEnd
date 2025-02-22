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
	private String product1;
	@Column(name = "product2", nullable = true)
	private String product2 = null;
	@Column(name = "product3", nullable = true)
	private String product3 = null;
	@Column(name = "totalValue")
	private double totalValue;
	@Column(name = "valueProduct1")
	private double valueProduct1;
	@Column(name = "valueProduct2")
	private double valueProduct2;
	@Column(name = "valueProduct3")
	private double valueProduct3;
	
	
	public Orders() {
		super();
	}
	
	
	public Orders(long id, String product1, String product2, String product3, double totalValue, double valueProduct1,
			double valueProduct2, double valueProduct3) {
		super();
		this.id = id;
		this.product1 = product1;
		this.product2 = product2;
		this.product3 = product3;
		this.totalValue = totalValue;
		this.valueProduct1 = valueProduct1;
		this.valueProduct2 = valueProduct2;
		this.valueProduct3 = valueProduct3;
	}

	

	public double getValueProduct1() {
		return valueProduct1;
	}


	public void setValueProduct1(double valueProduct1) {
		this.valueProduct1 = valueProduct1;
	}


	public double getValueProduct2() {
		return valueProduct2;
	}


	public void setValueProduct2(double valueProduct2) {
		this.valueProduct2 = valueProduct2;
	}


	public double getValueProduct3() {
		return valueProduct3;
	}


	public void setValueProduct3(double valueProduct3) {
		this.valueProduct3 = valueProduct3;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduct1() {
		return product1;
	}
	public void setProduct1(String product1) {
		this.product1 = product1;
	}
	public String getProduct2() {
		return product2;
	}
	public void setProduct2(String product2) {
		this.product2 = product2;
	}
	public String getProduct3() {
		return product3;
	}
	public void setProduct3(String product3) {
		this.product3 = product3;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
