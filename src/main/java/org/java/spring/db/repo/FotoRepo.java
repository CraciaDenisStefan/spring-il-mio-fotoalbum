package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {

	List<Foto> findByTitoloContainingIgnoreCase(String Titolo);
}
