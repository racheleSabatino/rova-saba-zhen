package it.polimi.traveldreamsystemEJB;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mail;

	private String cognome;

	private String nome;

	private String password;

	private String tipoUtente;

	//bi-directional many-to-one association to Personalizz
	@OneToMany(mappedBy="utente")
	private List<Personalizz> personalizzs;

	public Utente() {
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUtente() {
		return this.tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}

	public List<Personalizz> getPersonalizzs() {
		return this.personalizzs;
	}

	public void setPersonalizzs(List<Personalizz> personalizzs) {
		this.personalizzs = personalizzs;
	}

	public Personalizz addPersonalizz(Personalizz personalizz) {
		getPersonalizzs().add(personalizz);
		personalizz.setUtente(this);

		return personalizz;
	}

	public Personalizz removePersonalizz(Personalizz personalizz) {
		getPersonalizzs().remove(personalizz);
		personalizz.setUtente(null);

		return personalizz;
	}

}