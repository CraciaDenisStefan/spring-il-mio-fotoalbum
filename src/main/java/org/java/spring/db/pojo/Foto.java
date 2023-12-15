package org.java.spring.db.pojo;

import java.util.Arrays; 
import java.util.List;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
    @NotEmpty(message = "Il campo titolo è obbligatorio")
	 private String titolo;
	
	@Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Il campo descrizione è obbligatorio")
	 private String descrizione;
	
	@NotEmpty(message = "Il campo fotoUrl è obbligatorio")
	 private String url;
	

	@NotNull(message = "Il campo visibile è obbligatorio")
	private Boolean visibile;
	
	@ManyToMany
	private List<Categorie> categorie;
	 
	 public Foto() { }
	 public Foto(String titolo, String descrizione, String url,Boolean visibile, Categorie... categorie) {
			setTitolo(titolo);
			setDescrizione(descrizione);
			setUrl(url);
			setVisibile(visibile);
			setCategorie(categorie);
		}
	 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getVisibile() {
		return visibile;
	}
	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}
	 
	 
	public List<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}
	public void setCategorie(Categorie... categorie) {	
		setCategorie(Arrays.asList(categorie));
	}
}
