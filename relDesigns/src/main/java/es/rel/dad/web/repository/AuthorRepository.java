package es.rel.dad.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.rel.dad.web.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{
	
	Author findByNameAuthor(String name);
	List<Author> findAll();

}
