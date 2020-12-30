package br.com.SGOTBackEnd.model;

public class Product {

	private String name;
	private String description;
	private double value;
	
	
	public Product(String name, String description, double value) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
