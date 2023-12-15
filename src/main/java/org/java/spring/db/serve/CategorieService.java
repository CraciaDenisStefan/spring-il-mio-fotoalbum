package org.java.spring.db.serve;

import java.util.List; 

import org.java.spring.db.pojo.Categorie;
import org.java.spring.db.repo.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepo categorieRepo;

public List<Categorie> findAll() {
		
		return categorieRepo.findAll();
	}
	public Categorie findById(int id) {
		
		return categorieRepo.findById(id).get();
	}
	public void save(Categorie categorie) {
		
		categorieRepo.save(categorie);
	}
	public List<Categorie> findByTitolo(String query) {
		
		return categorieRepo.findByTitoloContainingIgnoreCase(query);
	}

	public void delete(Categorie categorie) {
		
		categorieRepo.delete(categorie);
	}
}
