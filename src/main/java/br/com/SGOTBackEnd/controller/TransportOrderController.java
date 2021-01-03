package br.com.SGOTBackEnd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.SGOTBackEnd.model.TransportOrder;
import br.com.SGOTBackEnd.repository.TransportOrderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TransportOrderController {

	@Autowired
	private TransportOrderRepository transportRepository;
	
	//getTransportOrders
	@GetMapping("transportorders")
	public List<TransportOrder> getAllTransportsOrders() {
		return this.transportRepository.findAll();
	}
	
	//getTransportOrderById
	@GetMapping("/transportorders/{id}")
	public ResponseEntity<TransportOrder> getTransportOrderById(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
		TransportOrder transportOrder = transportRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado uma Ordem de Transporte para o produto de id: " + orderId));
		return ResponseEntity.ok().body(transportOrder);
	}
	
	//createTransportOrder
	@PostMapping("transportorders")
	public TransportOrder createOrder(@RequestBody TransportOrder transportOrder) {
		return this.transportRepository.save(transportOrder);
	}
	//updateTransportOrder
	@PutMapping("/transportorders/{id}")
	public ResponseEntity<TransportOrder> updateTransportOrder(@PathVariable(value = "id") Long orderId,
			@Validated @RequestBody TransportOrder transportOrderDetails) throws ResourceNotFoundException {
		TransportOrder transportOrder = transportRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado uma Ordem de Transporte para o produto de id: " + orderId));
		transportOrder.setSent(transportOrderDetails.isSent());;
		
		return ResponseEntity.ok(this.transportRepository.save(transportOrder));
	}
	//deleteTransportOrder
	@DeleteMapping("/transportorders/{id}")
	public Map<String, Boolean> deleteTransportOrder(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
		TransportOrder transportOrder = transportRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado uma Ordem de Transporte para o produto de id: " + orderId));
		this.transportRepository.delete(transportOrder);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
