package br.com.SGOTBackEnd.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.SGOTBackEnd.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

		@Query(value = "SELECT * FROM tbl_orders, tbl_transport_order WHERE tbl_orders.id = tbl_transport_order.id_product AND tbl_orders.total_value > 500;", nativeQuery=true)
		List<Orders> findBytotalValueGreaterThan(double totalValue);
		@Query(value = "SELECT MAX(id) FROM tbl_orders", nativeQuery=true)
	    int lastIdInserted();

		@Query(value = "SELECT * FROM tbl_orders INNER JOIN tbl_transport_order ON (tbl_orders.id = tbl_transport_order.id_product);", nativeQuery=true)
		List<Orders> getAllOrders2();
}
