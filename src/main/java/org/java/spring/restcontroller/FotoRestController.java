package org.java.spring.restcontroller;


import java.util.List; 

import org.java.spring.db.pojo.Foto;
import org.java.spring.db.pojo.Messaggio;
import org.java.spring.db.serve.FotoService;
import org.java.spring.db.serve.MessaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/foto")
public class FotoRestController {
	@Autowired
	private FotoService fotoService;
	@Autowired
	private MessaggioService messaggioService;
	
	@GetMapping
	public ResponseEntity<List<Foto>> getIndex(@RequestParam(required = false) String titolo) {
		
		List<Foto> foto;

        if (titolo != null && !titolo.isEmpty()) {
     
            foto = fotoService.findByTitolo(titolo);
        } else {
       
            foto = fotoService.findAll();
        }

        return new ResponseEntity<>(foto, HttpStatus.OK);
	}
 
	
	@GetMapping("{id}")
	public ResponseEntity<Foto> getFoto(@PathVariable int id) {
		
		Foto foto = fotoService.findById(id);
		
		if (foto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Messaggio> create(@RequestBody Messaggio messaggio) {
		
		messaggioService.save(messaggio);
		
		return new ResponseEntity<>(messaggio, HttpStatus.OK);
	}
}
