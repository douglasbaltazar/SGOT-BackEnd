package br.com.SGOTBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SGOTBackEnd.model.TransportOrder;

@Repository
public interface TransportOrderRepository extends JpaRepository<TransportOrder, Long> {

	
}
