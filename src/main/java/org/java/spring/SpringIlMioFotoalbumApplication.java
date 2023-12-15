package org.java.spring;




import org.java.spring.db.pojo.Categorie;
import org.java.spring.db.pojo.Foto;
import org.java.spring.db.serve.CategorieService;
import org.java.spring.db.serve.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{

	@Autowired
	private FotoService fotoService;
	@Autowired
	private CategorieService categorieService;
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie("montagna");
		Categorie cat2 = new Categorie("mare");
		Categorie cat3 = new Categorie("lago");
		Categorie cat4 = new Categorie("varie");
		
		categorieService.save(cat1);
		categorieService.save(cat2);
		categorieService.save(cat3);
		categorieService.save(cat4);
		
		fotoService.save(new Foto("foto1","desc1","url1",false,cat1));
		fotoService.save(new Foto("foto2","desc2","url2",true));
		

		
	}

}
