package org.java.spring.controller;

import java.util.List;


import org.java.spring.db.pojo.Messaggio;
import org.java.spring.db.serve.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MessaggioController {

	@Autowired
	private MessaggioService messaggioService;
	
	@GetMapping("/messaggi")
	public String getMessagio(Model model) {
		
		List<Messaggio> messaggio =  messaggioService.findAll();
				
		
		model.addAttribute("messaggio", messaggio);
	
		
		return "MessaggioIndex";
	}
	
	@GetMapping("/messaggi/{id}")
	public String getMessaggio(Model model,
			@PathVariable int id) {
		
		Messaggio messaggio = messaggioService.findById(id);
		
		
		model.addAttribute("messaggio", messaggio);
	
	
		
		return "messaggio";
	}
	
}
