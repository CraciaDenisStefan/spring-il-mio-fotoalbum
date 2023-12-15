package org.java.spring.db.repo;

import org.java.spring.db.pojo.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepo extends JpaRepository<Messaggio, Integer>{

}
