package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	 
	 
	 public Foto() { }
	 public Foto(String titolo, String descrizione, String url,Boolean visibile) {
			setTitolo(titolo);
			setDescrizione(descrizione);
			setUrl(url);
			setVisibile(visibile);
			
		
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
	 
	 
}
