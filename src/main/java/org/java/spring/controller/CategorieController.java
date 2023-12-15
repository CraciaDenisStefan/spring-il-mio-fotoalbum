package org.java.spring.controller;

import java.util.List; 

import org.java.spring.db.pojo.Categorie;
import org.java.spring.db.pojo.Foto;
import org.java.spring.db.serve.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("/categorie")
	public String getCategorie(Model model,@RequestParam(required = false) String search) {
		
		List<Categorie> categorie = search == null  
				? categorieService.findAll()
				: categorieService.findByTitolo(search);
		
		model.addAttribute("categorie", categorie);
		model.addAttribute("search", search == null ? "" : search);
		
		return "CategorieIndex";
	}
	
	/////////////////////
	@GetMapping("/categorie/create")
	public String createCategorie(Model model) {
		
	
		Categorie categorie = new Categorie();	
				
		model.addAttribute("categorie", categorie);
	
		return "categorie-form";
	}
	
	@PostMapping("/categorie/create")
	public String storeCategorie(
			Model model,
			@Valid @ModelAttribute Categorie categorie, 
			BindingResult bindingResult) {
		
				
		return saveCategorie(model, categorie, bindingResult);
	}
	
	@GetMapping("/categorie/edit/{id}")
	public String editCategorie(Model model,
			@PathVariable int id) {
		
		Categorie categorie = categorieService.findById(id);
		model.addAttribute("categorie", categorie);
		return "categorie-form";
	}
	@PostMapping("/categorie/edit/{id}")
	public String updateCategorie(Model model,
			@Valid @ModelAttribute Categorie categorie, 
			BindingResult bindingResult) {
		
		return saveCategorie(model, categorie, bindingResult);
	}
	
	@PostMapping("/categorie/delete/{id}")
	public String delete(@PathVariable int id) {
		
		Categorie categorie = categorieService.findById(id);
       
		 if (categorie.getFoto() != null) {
		        for (Foto foto : categorie.getFoto()) {
		            foto.getCategorie().remove(categorie);
		        }
		    }

		   
		    categorie.getFoto().clear();


        categorieService.delete(categorie);
			
		return "redirect:/categorie";
	}
	
	private String saveCategorie(Model model,
			@Valid @ModelAttribute Categorie categorie, 
			BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			model.addAttribute("categorie", categorie);
			return "categorie-form";
		}
			
			categorieService.save(categorie);
			  
		return "redirect:/categorie";
	}
}
