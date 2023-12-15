package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Foto;
import org.java.spring.db.serve.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FotoController {

	@Autowired
	private FotoService fotoService;
	
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
		
		
		model.addAttribute("foto", foto);
	
		
		return "foto";
	}
}
