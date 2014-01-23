package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Utente database table.
 * 
 */
@Entity
@Table(name = "utente")
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String _CLIENTE = "CLIENTE";
	public static final String _IMPIEGATO = "IMPIEGATO";
	public static final String _AMMINISTRATORE = "AMMINISTRATORE";

	@Id
	@Column(name = "MAIL", unique = true, nullable = false, length = 45)
	private String mail;

	@Column(name = "COGNOME", nullable = false, length = 45)
	private String cognome;

	@Column(name = "NOME", nullable = false, length = 45)
	private String nome;

	@Column(name = "PASSWORD", nullable = false, length = 64)
	private String password;

	@Column(name = "TIPOUTENTE", nullable = false, length = 45)
	private String tipoutente;

    @OneToMany(mappedBy="Utente")
    private List<PacchPer> pacchPer;

	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name = "REGISTEREDON", nullable = false)
	private Date registeredOn;

	public Utente() {}

	public Utente(UtenteDTO utente) {
		this.mail = utente.getMail();
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.password = DigestUtils.sha256Hex(utente.getPassword());
		this.tipoutente = utente.getTipoUtente();
		this.registeredOn = new Date();
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

	public void setTipoUtente(String tipoutente) {
		this.tipoutente = tipoutente;
	}

	public List<PacchPer> getPacchPer() {
		return pacchPer;
	}

	public void setPacchPer(List<PacchPer> pacchPer) {
		this.pacchPer = pacchPer;
	}

}