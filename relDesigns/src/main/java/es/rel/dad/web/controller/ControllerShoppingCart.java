package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.rel.dad.web.entity.Author;
import es.rel.dad.web.entity.Client;
import es.rel.dad.web.entity.Item;
import es.rel.dad.web.entity.Orders;
import es.rel.dad.web.repository.AuthorRepository;
import es.rel.dad.web.repository.ClientRepository;
import es.rel.dad.web.repository.ItemRepository;
import es.rel.dad.web.repository.OrdersRepository;


@Controller
public class ControllerShoppingCart {

	
	@Autowired private ClientRepository client;
	@Autowired private OrdersRepository orders;
	@Autowired private ItemRepository items;
	@Autowired private AuthorRepository author;

	@GetMapping("/cart/{name}/{nameItem}/{nameAuthor}")
	public String carrito(Model model, @PathVariable String name,  @PathVariable String nameItem, @PathVariable String nameAuthor) {
				
		Optional<Client> c = client.findByName(name);
		Author cate = author.findByNameAuthor(nameAuthor);
		
		List <Item> aux = new ArrayList<Item>(cate.getItems());
		Item itemAux = items.findByNameItem(nameItem);
		
		if(c.get().getCarrito().contains(nameItem) == false) {
			c.get().getItems().add(itemAux);
		}
		
		if(itemAux.getStock() > 0) {
			itemAux.setStock( itemAux.getStock()-1);
			c.get().getCarrito().add(nameItem);
			client.save(c.get());
			items.save(itemAux);
		}

		model.addAttribute("items", aux);		
		model.addAttribute("client",c);
		model.addAttribute("author",cate);
		return "authorItems";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart(Model model) {
		return "shoppingCart";
	}
	
	@GetMapping("/shoppingCart/{name}")
	public String shoppingCart(Model model, @PathVariable String name, HttpServletRequest request) {
		
		Optional<Client> c = client.findByName(name);

		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c);
		return "shoppingCart";
	}

	@GetMapping("/pay/{name}")
	public String pay(Model model, @PathVariable String name, HttpServletRequest request) {
		
		
		Optional<Client> c = client.findByName(name);
		if(c.get().getCarrito().size() > 0) {
			
			for(Item xx : c.get().getItems()) {
				System.out.println("Name : "+xx.getName());
			}
			
			List aux = new ArrayList<Item>(c.get().getItems());
			Orders orden1 = new Orders(aux);	
			orders.save(orden1);
			
			c.get().setCarrito(new ArrayList<String>());
			c.get().setItems(new ArrayList<Item>());
			
			c.get().getOrders().add(orden1);
			
			client.save(c.get());

		}
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	@GetMapping("/delete/{name}/{food}")
	public String delete(Model model, @PathVariable String name, @PathVariable String food,  HttpServletRequest request) {
		Optional<Client> c = client.findByName(name);
		
		Iterator<Item> iter = c.get().getItems().iterator();
				
		
		while(iter.hasNext()){
			Item auxIt = iter.next();
			if(auxIt.getName().equals(food)) {
				iter.remove();
				c.get().getCarrito().remove(food);
			}
		}

		// Cambios
		client.save(c.get());
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	
}
