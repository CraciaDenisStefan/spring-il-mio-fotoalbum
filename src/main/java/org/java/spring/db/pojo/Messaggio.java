package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Messaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	@NotEmpty(message = "Il campo email è obbligatorio")
    private String email;
	
	@Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Il campo messaggio è obbligatorio")
    private String messaggio;



    public Messaggio() {
    }

    public Messaggio(String email, String messaggio) {
        setEmail(email);
        setMessaggio(messaggio);
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
}
