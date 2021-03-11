package es.rel.dad.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.rel.dad.web.entity.Client;
import es.rel.dad.web.repository.ClientRepository;


@Controller
public class ControllerContact {
	@Autowired private ClientRepository client;
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@GetMapping("/contact/{name}")
	public String contact(Model model, @PathVariable String name) {
		Client c = client.findByName(name);
		model.addAttribute("client",c);
		return "contact";
	}
}
