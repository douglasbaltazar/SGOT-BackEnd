package br.com.SGOTBackEnd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.SGOTBackEnd.exceptions.ResourceNotFoundException;
import br.com.SGOTBackEnd.model.Orders;
import br.com.SGOTBackEnd.repository.OrdersRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;
	
	// getOrders
	@GetMapping("orders")
	public List<Orders> getAllOrders() {
		return this.ordersRepository.findAll();
	}
	// getOrdersById
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um pedido com id: " + orderId));
		return ResponseEntity.ok().body(order);
	}
	
	// getOrdersByValueAbove500
	
	// codigo aqui
	
	// criar Order
	@PostMapping("orders")
	public Orders createOrder(@RequestBody Orders order) {
		return this.ordersRepository.save(order);
	}
	
	// updateOrder
	@PutMapping("/orders/{id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable(value = "id") Long orderId,
			@Validated @RequestBody Orders orderDetails) throws ResourceNotFoundException {
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um pedido com id: " + orderId));
		order.setProduct1(orderDetails.getProduct1());
		order.setProduct2(orderDetails.getProduct2());
		order.setProduct3(orderDetails.getProduct3());
		order.setTotalValue(orderDetails.getTotalValue());
		
		return ResponseEntity.ok(this.ordersRepository.save(order));
	}
	// deleteOrder
	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado um pedido com id: " + orderId));
		this.ordersRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
