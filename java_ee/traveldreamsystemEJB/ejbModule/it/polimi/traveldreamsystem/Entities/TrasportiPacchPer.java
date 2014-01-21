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
@Table(name="TrasportiPacchPer")
public class TrasportiPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDTRASPORTO", unique=true, nullable=false)
	private int idTrasporto;
	
	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;
	
	//bi-directional many-to-one association to PacchPred
			@ManyToOne
			@JoinColumn(name="idPacchPer", nullable=false)
			private List<PacchPer> pacchPers;

		//bi-directional many-to-one association to Trasporto
			@ManyToOne
			@JoinColumn(name="idprodbase", nullable=false)
			private List<Trasporto> trasporti;

	
	public TrasportiPacchPer(int idPacchPer, int idTrasporto) {
		this.idPacchPer = idPacchPer;
		this.idTrasporto = idTrasporto;
	}
	
	public void setIdTrasporto(int idTrasporto) {
		this.idTrasporto = idTrasporto;
	}
	
	public int getIdTrasporto(){
		return idTrasporto;
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
	
	public void setTrasporti(List<Trasporto> trasporti) {
		this.trasporti = trasporti;
	}
	
	public List<Trasporto> getTrasporti(){
		return trasporti;
	}
	
	
}
