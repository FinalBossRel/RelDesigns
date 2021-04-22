package urjc.es.designs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import urjc.es.designs.entity.Client;


public interface ClientRepository extends JpaRepository<Client,Long>{
	
	Client findByNameAndPassword(String name, String password);
	Optional<Client> findByName(String Name);
	//Client findByName(String Name);
	List<Client> findAll();
	
	Optional<Client> findById(Long id);

}
