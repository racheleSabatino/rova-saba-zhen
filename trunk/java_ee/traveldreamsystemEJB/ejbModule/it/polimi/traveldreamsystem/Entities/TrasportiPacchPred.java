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
@Table(name="TrasportiPacchPred")
public class TrasportiPacchPred implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDTRASPORTO", unique=true, nullable=false)
	int idTrasporto;
	
	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	int idPacchPred;
	
	//bi-directional many-to-one association to PacchPred
	@ManyToOne
	@JoinColumn(name="idPacchPred", nullable=false)
	private List<PacchPred> pacchPreds;

//bi-directional many-to-one association to Trasporto
	@ManyToOne
	@JoinColumn(name="idprodbase", nullable=false)
	private List<Trasporto> trasporti;
	
	public TrasportiPacchPred(int idPacchPred, int idTrasporto) {
		this.idPacchPred = idPacchPred;
		this.idTrasporto = idTrasporto;
	}
	
	public void setIdTrasporto(int idTrasporto) {
		this.idTrasporto = idTrasporto;
	}
	
	public int getIdTrasporto(){
		return idTrasporto;
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
	
	public void setTrasporti(List<Trasporto> trasporti) {
		this.trasporti = trasporti;
	}
	
	public List<Trasporto> getTrasporti(){
		return trasporti;
	}
	
}
