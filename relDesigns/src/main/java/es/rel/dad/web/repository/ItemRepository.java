package es.rel.dad.web.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
	List<Item> findAll();
	Item findByNameItem(String name);
}
