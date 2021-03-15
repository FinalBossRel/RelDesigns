package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
				
		Client c = client.findByName(name);
		Author cate = author.findByNameAuthor(nameAuthor);
		List <Item> aux = new ArrayList<Item>(cate.getItems());
		Item itemAux = items.findByNameItem(nameItem);
		
		if(c.getCarrito().contains(nameItem) == false) {
			c.getItems().add(itemAux);
		}
		
		if(itemAux.getStock() > 0) {
			itemAux.setStock( itemAux.getStock()-1);
			c.getCarrito().add(nameItem);
			client.save(c);
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
	public String shoppingCart(Model model, @PathVariable String name) {
		Client c = client.findByName(name);
		model.addAttribute("client",c);
		return "shoppingCart";
	}

	@GetMapping("/pay/{name}")
	public String pay(Model model, @PathVariable String name) {
		
		Client c = client.findByName(name);
		if(c.getCarrito().size() > 0) {
			
			for(Item xx : c.getItems()) {
				System.out.println("Name : "+xx.getName());
			}
			
			List aux = new ArrayList<Item>(c.getItems());
			Orders orden1 = new Orders(aux);	
			orders.save(orden1);
			
			c.setCarrito(new ArrayList<String>());
			c.setItems(new ArrayList<Item>());
			
			c.getOrders().add(orden1);
			
			client.save(c);

		}
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	@GetMapping("/delete/{name}/{food}")
	public String delete(Model model, @PathVariable String name, @PathVariable String food) {
		Client c = client.findByName(name);
		
		Iterator<Item> iter = c.getItems().iterator();
		
		while(iter.hasNext()){
			Item auxIt = iter.next();
			if(auxIt.getName().equals(food)) {
				iter.remove();
				c.getCarrito().remove(food);
			}
		}

		// Cambios
		client.save(c);
		model.addAttribute("client",c);
		return "shoppingCart";
	}
	
	
}
