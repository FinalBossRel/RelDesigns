package urjc.es.designs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urjc.es.designs.entity.Orders;



public interface OrdersRepository extends JpaRepository<Orders,Long>{
	//List<Order> findByNameOrder(int number);
}
