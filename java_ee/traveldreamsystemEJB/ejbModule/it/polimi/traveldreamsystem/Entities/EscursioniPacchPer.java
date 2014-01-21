package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EscursioniPacchPer")
public class EscursioniPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDESCURSIONE", unique=true, nullable=false)
	private int idEscursione;
	
	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;
	
	//bi-directional many-to-one association to PacchPred
	@ManyToOne
	@JoinColumn(name="idPacchPer", nullable=false)
	private List<PacchPer> pacchPers;

//bi-directional many-to-one association to Escursione
	@ManyToOne
	@JoinColumn(name="idprodbase", nullable=false)
	private List<Escursione> escursioni;
	
	public EscursioniPacchPer(int idPacchPer, int idEscursione) {
		this.idPacchPer = idPacchPer;
		this.idEscursione = idEscursione;
	}
	
	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}
	
	public int getIdEscursione(){
		return idEscursione;
	}
	
	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public int getIdPacchPer(){
		return idPacchPer;
	}
	

	public void setPacchPers(List<PacchPer> pacchPers) {
		this.pacchPers = pacchPers;
	}
	
	public List<PacchPer> getPacchPer(){
		return pacchPers;
	}
	
	public void setEscursioni(List<Escursione> escursioni) {
		this.escursioni = escursioni;
	}
	
	public List<Escursione> getEscursioni(){
		return escursioni;
	}
	
}
