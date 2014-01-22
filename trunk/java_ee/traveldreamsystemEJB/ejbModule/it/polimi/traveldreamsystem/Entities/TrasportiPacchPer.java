package it.polimi.traveldreamsystem.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TrasportiPacchPer")
public class TrasportiPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDTRASPORTO", referencedColumnName = "IDPRODBASE")
	private Trasporto trasporto;

	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO", nullable=false)
	private Date dataAcquisto;

	@Column(name="LISTAREGALI", nullable=false, length=45)
	private boolean listaRegali;
	
	public TrasportiPacchPer() {}

	public Trasporto getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
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

	
}