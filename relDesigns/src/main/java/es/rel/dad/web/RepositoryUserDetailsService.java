package es.rel.dad.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import es.rel.dad.web.entity.Author;
import es.rel.dad.web.entity.Client;
import es.rel.dad.web.repository.AuthorRepository;
import es.rel.dad.web.repository.ClientRepository;

@Service
public class RepositoryUserDetailsService implements UserDetailsService{
	
	@Autowired
	private ClientRepository repositorioClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Client client = repositorioClient.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : client.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		return new org.springframework.security.core.userdetails.User(client.getName(), client.getPassword(), roles);

	}
}
