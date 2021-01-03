package br.com.SGOTBackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_transportOrder")
public class TransportOrder {
	@Id
	@Column(name = "id_product")
	private long idProduct;
	
	@Column(name = "sent", nullable = false)
	private boolean sent = false;
	
	public TransportOrder() {
		super();	
	}
	public TransportOrder(long idProduct, boolean sent) {
		super();
		this.idProduct = idProduct;
		this.sent = sent;
	}
	
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	
	

}
