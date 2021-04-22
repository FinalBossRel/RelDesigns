package urjc.es.designs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import urjc.es.designs.entity.Author;


public interface AuthorRepository extends JpaRepository<Author,Long>{
	
	Author findByNameAuthor(String name);
	List<Author> findAll();

}
