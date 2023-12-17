package org.java.spring;




import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
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
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie("montagna");
		Categorie cat2 = new Categorie("mare");
		Categorie cat3 = new Categorie("lago");
		Categorie cat4 = new Categorie("varie");
		Categorie cat5 = new Categorie("animali");
		
		categorieService.save(cat1);
		categorieService.save(cat2);
		categorieService.save(cat3);
		categorieService.save(cat4);
		categorieService.save(cat5);
		
		fotoService.save(new Foto("Billy","il mio cane","https://www.focus.it/images/2022/05/03/cani_1020x680.jpg",true,cat5));
		fotoService.save(new Foto("Mochi","la mia gatta","https://wips.plug.it/cips/paginegialle.it/magazine/cms/2021/02/shutterstock_603117302.jpg?w=744&h=418&a=c",true,cat5));
		fotoService.save(new Foto("Everest","gita in montagna","https://www.nationalgeographic.it/upload/ngi-hero/002_NationalGeographic_2758852.jpg?w=1600&h=900",true,cat1));
		fotoService.save(new Foto("Elba","vacanza al Elba","https://www.traghetti-elbareservation.it/wp-content/uploads/2021/06/isola-delba.jpg",true,cat2));
		fotoService.save(new Foto("Io","foto di me","https://www.seisette.it/wp-content/uploads/2016/09/Programmatore01.jpg",false));
		
		
		Role roleAdmin = new Role("ADMIN");

		

		roleService.save(roleAdmin);
		
		String pws = AuthConf.passwordEncoder().encode("pws");
		

		User Admin = new User("Admin", pws, roleAdmin);
		

		userService.save(Admin);
		
	}

}
