package it.polimi.traveldreamsystem.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the personalizz database table.
 * 
 */
@Embeddable
public class PersonalizzPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int pacchPersID;

	@Column(insertable=false, updatable=false)
	private String cliente;

	@Column(insertable=false, updatable=false)
	private int prodBaseID;

	public PersonalizzPK() {
	}
	public int getPacchPersID() {
		return this.pacchPersID;
	}
	public void setPacchPersID(int pacchPersID) {
		this.pacchPersID = pacchPersID;
	}
	public String getCliente() {
		return this.cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getProdBaseID() {
		return this.prodBaseID;
	}
	public void setProdBaseID(int prodBaseID) {
		this.prodBaseID = prodBaseID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonalizzPK)) {
			return false;
		}
		PersonalizzPK castOther = (PersonalizzPK)other;
		return 
			(this.pacchPersID == castOther.pacchPersID)
			&& this.cliente.equals(castOther.cliente)
			&& (this.prodBaseID == castOther.prodBaseID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pacchPersID;
		hash = hash * prime + this.cliente.hashCode();
		hash = hash * prime + this.prodBaseID;
		
		return hash;
	}
}