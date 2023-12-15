package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Categorie;
import org.java.spring.db.pojo.Foto;
import org.java.spring.db.serve.CategorieService;
import org.java.spring.db.serve.FotoService;
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
public class FotoController {

	@Autowired
	private FotoService fotoService;
	@Autowired
	private CategorieService categorieService;
	
	
	@GetMapping("/")
	public String getFoto(Model model,@RequestParam(required = false) String search) {
		
		List<Foto> foto = search == null  
				? fotoService.findAll()
				: fotoService.findByTitolo(search);
		
		model.addAttribute("foto", foto);
		model.addAttribute("search", search == null ? "" : search);
		
		return "index";
	}
	
	@GetMapping("/foto/{id}")
	public String geFoto(Model model,
			@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
		List<Categorie> categorie = foto.getCategorie();
		
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
	
		
		return "foto";
	}
	
	@GetMapping("/foto/create")
	public String createfoto(Model model) {
		
		List<Categorie> categorie = categorieService.findAll();
		Foto foto = new Foto();	
				
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
	
		return "foto-form";
	}
	
	@PostMapping("/foto/create")
	public String storeFoto(
			Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult) {
		
				
		return saveFoto(model, foto, bindingResult);
	}
	
	@GetMapping("/foto/edit/{id}")
	public String editFoto(Model model,
			@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
		List<Categorie> categorie = categorieService.findAll();
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
		return "foto-form";
	}
	@PostMapping("/foto/edit/{id}")
	public String updatefoto(Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult) {
		
		return saveFoto(model, foto, bindingResult);
	}
	
	@PostMapping("/foto/delete/{id}")
	public String delete(@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
       
		 if (foto.getCategorie() != null) {
		        for (Categorie categorie : foto.getCategorie()) {
		            categorie.getFoto().remove(foto);
		        }
		    }

		   
		    foto.getCategorie().clear();


        fotoService.delete(foto);
			
		return "redirect:/";
	}
	
	private String saveFoto(Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			model.addAttribute("foto", foto);
			return "foto-form";
		}
			
			fotoService.save(foto);
			  
		return "redirect:/";
	}
}
