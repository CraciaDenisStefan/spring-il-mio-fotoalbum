package org.java.spring.db.serve;

import org.java.spring.db.pojo.Messaggio;
import org.java.spring.db.repo.MessaggioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessaggioService {

	@Autowired
	private MessaggioRepo messaggioRepo;
	
	public void save(Messaggio messaggio) {
		
		messaggioRepo.save(messaggio);
	}
}
