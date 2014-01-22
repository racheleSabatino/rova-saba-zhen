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
@Table(name = "EscursioniPacchPer")
public class EscursioniPacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "IDESCURSIONE", referencedColumnName = "IDPRODBASE")
	private Escursione escursioni;

	@Id
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAACQUISTO", nullable=false)
	private Date dataAcquisto;

	@Column(name="LISTAREGALI", nullable=false, length=45)
	private boolean listaRegali;

	public EscursioniPacchPer() {
		
	}
}
