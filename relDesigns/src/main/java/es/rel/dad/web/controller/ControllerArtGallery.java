package es.rel.dad.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.rel.dad.web.entity.Category;
import es.rel.dad.web.entity.Client;
import es.rel.dad.web.entity.Item;
import es.rel.dad.web.repository.CategoryRepository;
import es.rel.dad.web.repository.ClientRepository;
import es.rel.dad.web.repository.ItemRepository;



@Controller
public class ControllerArtGallery {

	@Autowired private ClientRepository client;
	@Autowired private ItemRepository items;
	@Autowired private CategoryRepository category;
	
	@GetMapping("/food")
	public String food(Model model){
		List <Item> aux = new ArrayList<Item>(items.findAll());
		List<Category> cate = new ArrayList<Category>(category.findAll());
		model.addAttribute("category",cate);
		model.addAttribute("items", aux);
		
		return "food";
	}
	
	@GetMapping("/food/{name}")
	public String food(Model model,  @PathVariable String name){
		Client c = client.findByName(name);

		List<Category> cate = new ArrayList<Category>(category.findAll());
		
		
		model.addAttribute("category",cate);
		model.addAttribute("client",c);
		
		return "food";
	}
	
	@GetMapping("/category/{nameCategory}")
	public String aniadir(Model model, @PathVariable String nameCategory) {
		
		Category cate = category.findByNameCategory(nameCategory);
		List <Item> aux = new ArrayList<Item>(cate.getItems());		
		
		model.addAttribute("items", aux);		
		return "categoryItems";
	}
	
	@GetMapping("/category/{name}/{nameCategory}")
	public String aniadir(Model model, @PathVariable String name, @PathVariable String nameCategory) {
		
		Client c = client.findByName(name);
		Category cate = category.findByNameCategory(nameCategory);
		List <Item> aux = new ArrayList<Item>(cate.getItems());		
		
		model.addAttribute("category", cate);	
		model.addAttribute("items", aux);		
		model.addAttribute("client",c);
		return "categoryItems";
		
	}

}
