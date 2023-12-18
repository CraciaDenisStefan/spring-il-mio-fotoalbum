package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.auth.db.pojo.User;
import org.java.spring.db.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {

	List<Foto> findByTitoloContainingIgnoreCase(String titolo);

    List<Foto> findByUser(User user);

    List<Foto> findByUserAndTitoloContainingIgnoreCase(User user, String titolo);
}
