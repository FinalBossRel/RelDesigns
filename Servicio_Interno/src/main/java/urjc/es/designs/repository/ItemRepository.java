package urjc.es.designs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import urjc.es.designs.entity.Item;


public interface ItemRepository extends JpaRepository<Item,Long>{
	List<Item> findAll();
	Item findByNameItem(String name);
}
