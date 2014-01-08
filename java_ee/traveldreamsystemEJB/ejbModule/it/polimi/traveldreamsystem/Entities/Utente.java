package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Utente database table.
 * 
 */
@Entity
@Table(name="Utente")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAIL", unique=true, nullable=false, length=45)
	private String mail;

	@Column(name="COGNOME", nullable=false, length=45)
	private String cognome;

	@Column(name="NOME", nullable=false, length=45)
	private String nome;

	@Column(name="PASSWORD", nullable=false, length=64)
	private String password;

	@Column(name="TIPOUTENTE", nullable=false, length=45)
	private String tipoutente;

	//bi-directional many-to-one association to PacchPer
	@OneToMany(mappedBy="utente")
	private List<PacchPer> pacchPers;

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

	public String getTipoutente() {
		return this.tipoutente;
	}

	public void setTipoutente(String tipoutente) {
		this.tipoutente = tipoutente;
	}

	public List<PacchPer> getPacchPers() {
		return this.pacchPers;
	}

	public void setPacchPers(List<PacchPer> pacchPers) {
		this.pacchPers = pacchPers;
	}

	public PacchPer addPacchPer(PacchPer pacchPer) {
		getPacchPers().add(pacchPer);
		pacchPer.setUtente(this);

		return pacchPer;
	}

	public PacchPer removePacchPer(PacchPer pacchPer) {
		getPacchPers().remove(pacchPer);
		pacchPer.setUtente(null);

		return pacchPer;
	}

}