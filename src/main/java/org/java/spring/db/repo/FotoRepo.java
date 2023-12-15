package org.java.spring.db.repo;

import org.java.spring.db.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {

}
