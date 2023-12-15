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
		
		categorieService.save(cat1);
		categorieService.save(cat2);
		categorieService.save(cat3);
		categorieService.save(cat4);
		
		fotoService.save(new Foto("foto1","desc1","url1",false,cat1));
		fotoService.save(new Foto("foto2","desc2","url2",true));
		
		
		Role roleAdmin = new Role("ADMIN");

		

		roleService.save(roleAdmin);
		
		String pws = AuthConf.passwordEncoder().encode("pws");
		

		User Admin = new User("Admin", pws, roleAdmin);
		

		userService.save(Admin);
		
	}

}
