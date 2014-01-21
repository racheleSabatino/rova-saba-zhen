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
@Table(name="EscursioniPacchPred")
public class EscursioniPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDESCURSIONE", unique=true, nullable=false)
	private int idEscursione;
	
	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	private int idPacchPred;
	
	//bi-directional many-to-one association to PacchPred
		@ManyToOne
		@JoinColumn(name="idPacchPer", nullable=false)
		private List<PacchPred> pacchPreds;

	//bi-directional many-to-one association to Escursione
		@ManyToOne
		@JoinColumn(name="idprodbase", nullable=false)
		private List<Escursione> escursioni;
	
	public EscursioniPacchPred(int idPacchPred, int idEscursione) {
		this.idPacchPred = idPacchPred;
		this.idEscursione = idEscursione;
	}
	
	public void setIdEscursione(int idEscursione) {
		this.idEscursione = idEscursione;
	}
	
	public int getIdEscursione(){
		return idEscursione;
	}
	
	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}
	
	public int getIdPacchPred(){
		return idPacchPred;
	}
	
	public void setPacchPreds(List<PacchPred> pacchPreds) {
		this.pacchPreds = pacchPreds;
	}
	
	public List<PacchPred> getPacchPred(){
		return pacchPreds;
	}
	
	public void setEscursioni(List<Escursione> escursioni) {
		this.escursioni = escursioni;
	}
	
	public List<Escursione> getEscursioni(){
		return escursioni;
	}
	
}