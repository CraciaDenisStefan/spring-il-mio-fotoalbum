package org.java.spring.db.serve;


import java.util.List; 

import org.java.spring.auth.db.pojo.User;
import org.java.spring.db.pojo.Foto;
import org.java.spring.db.repo.FotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

	@Autowired
	private FotoRepo fotoRepo;
	
public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	public Foto findById(int id) {
		
		return fotoRepo.findById(id).get();
	}

	public void save(Foto foto) {
		
		fotoRepo.save(foto);
	}
	
	 public List<Foto> findByUser(User user) {
	        return fotoRepo.findByUser(user);
	    }
	 public List<Foto> findByUserAndTitolo(User user, String titolo) {
	        return fotoRepo.findByUserAndTitoloContainingIgnoreCase(user, titolo);
	    }
	 public List<Foto> findByTitolo(String query) {
			
			return fotoRepo.findByTitoloContainingIgnoreCase(query);
		}

	public void delete(Foto foto) {
		
		fotoRepo.delete(foto);
	}
}
