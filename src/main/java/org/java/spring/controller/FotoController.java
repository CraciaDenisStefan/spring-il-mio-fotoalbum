package org.java.spring.controller;

import java.util.List;

import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.db.pojo.Categorie;
import org.java.spring.db.pojo.Foto;
import org.java.spring.db.serve.CategorieService;
import org.java.spring.db.serve.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
	public String getFoto(Model model, @RequestParam(required = false) String search, Authentication authentication) {
	    if (authentication != null && authentication.getPrincipal() instanceof User) {
	        User user = (User) authentication.getPrincipal();

	        List<Foto> foto = null;
	        
	        if (userHasAdminRole(user)) {
	            foto = (search == null) ? fotoService.findByUser(user) : fotoService.findByUserAndTitolo(user, search);
	        } else if (userHasSuperAdminRole(user)) {
	           foto = (search == null) ? fotoService.findAll() : fotoService.findByTitolo(search);
	        }

	        model.addAttribute("foto", foto);
	        model.addAttribute("search", (search == null) ? "" : search);
	        return "index";
	    } else {
	   
	        return "redirect:/login";
	    }
	}

	private boolean userHasAdminRole(User user) {
	    for (Role role : user.getRoles()) {
	        if ("ADMIN".equals(role.getName())) {
	            return true;
	        }
	    }
	    return false;
	}
	private boolean userHasSuperAdminRole(User user) {
	    for (Role role : user.getRoles()) {
	        if ("SUPERADMIN".equals(role.getName())) {
	            return true;
	        }
	    }
	    return false;
	}

	@GetMapping("/foto/{id}")
	public String getFoto(Model model, @PathVariable int id, Authentication authentication) {
	    User user = (User) authentication.getPrincipal();
	    Foto foto = fotoService.findById(id);
	    
	  
	    if (!(foto.getUser().getId() == (user.getId()))) {
	        return "redirect:/access-denied";
	    }

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
			BindingResult bindingResult,
			Authentication authentication) {
		User user = (User) authentication.getPrincipal();
	    foto.setUser(user);
				
		return saveFoto(model, foto, bindingResult);
	}
	
	@GetMapping("/foto/edit/{id}")
	public String editFoto(Model model,
			@PathVariable int id,
			Authentication authentication) {
		  User user = (User) authentication.getPrincipal();
		Foto foto = fotoService.findById(id);
		
		 if (!(foto.getUser().getId() == user.getId() || userHasSuperAdminRole(user))) {
		        return "redirect:/access-denied";
		    }
		
		List<Categorie> categorie = categorieService.findAll();
		model.addAttribute("foto", foto);
		model.addAttribute("categorie", categorie);
		return "foto-form";
	}
	@PostMapping("/foto/edit/{id}")
	public String updatefoto(Model model,
			@Valid @ModelAttribute Foto foto, 
			BindingResult bindingResult,
			Authentication authentication) {
		
		User user = (User) authentication.getPrincipal();
	    foto.setUser(user);
		return saveFoto(model, foto, bindingResult);
	}
	
	@PostMapping("/foto/delete/{id}")
	public String delete(@PathVariable int id,Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Foto foto = fotoService.findById(id);
       
		if (!(foto.getUser().getId() == (user.getId()))) {
	        return "redirect:/access-denied";
	    }
		
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
