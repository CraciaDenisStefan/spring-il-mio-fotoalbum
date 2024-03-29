package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository <Categorie, Integer> {

	List<Categorie> findByTitoloContainingIgnoreCase(String Titolo);
}
