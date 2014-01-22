package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PacchPer database table.
 * 
 */
@Entity
@Table(name="pacchper")
@NamedQuery(name="PacchPer.findAll", query="SELECT p FROM PacchPer p")
public class PacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO", nullable=false)
	private Date dataAcquisto;

	@Column(name="LISTAREGALI", nullable=false, length=45)
	private boolean listaRegali;
	
	@ManyToOne
	@JoinColumn(name = "IDPACCHPRED", referencedColumnName = "IDPACCHPRED")
	private PacchPred pacchPred;

	@ManyToOne
	@JoinColumn(name = "IDHOTEL", referencedColumnName = "IDPRODBASE")
	private List<Hotel> hotelsPacchPer;
	
	public PacchPer() {}

	public PacchPer(PacchPerDTO newPacchetto) {
		// TODO Auto-generated constructor stub
	}

	public int getIdPacchPer() {
		return idPacchPer;
	}

	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public boolean isListaRegali() {
		return listaRegali;
	}

	public void setListaRegali(boolean listaRegali) {
		this.listaRegali = listaRegali;
	}

	public PacchPred getPacchPred() {
		return pacchPred;
	}

	public void setPacchPred(PacchPred pacchPred) {
		this.pacchPred = pacchPred;
	}
	
}