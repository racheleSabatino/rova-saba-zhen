package it.polimi.traveldreamsystem.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UtenteDTO {
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message="invalid email")
	private String mail;
	
	@NotEmpty
    private String cognome;
	
	@NotEmpty
    private String nome;
	
	@NotEmpty
    private String password;
	
	@NotEmpty
    private String tipoutente;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoutente() {
		return tipoutente;
	}

	public void setTipoutente(String tipoutente) {
		this.tipoutente = tipoutente;
	}
     

}
