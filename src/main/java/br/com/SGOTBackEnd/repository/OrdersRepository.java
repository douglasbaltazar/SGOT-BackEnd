package br.com.SGOTBackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SGOTBackEnd.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
