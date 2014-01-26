package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the PacchPred database table.
 * 
 */
@Entity
@Table(name = "PacchPred")
@NamedQuery(name = "PacchPred.findAll", query = "SELECT p FROM PacchPred p")
public class PacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPACCHPRED", unique = true, nullable = false)
	private int idPacchPred;

	@Lob
	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	 @OneToMany(mappedBy="pacchPred")
	    private List<HotelsPacchPred> hotelsPacchPred;

	    @OneToMany(mappedBy="pacchPred")
	    private List<EscursioniPacchPred> escursionePacchPred;

	    @OneToMany(mappedBy="pacchPred")
	    private List<TrasportiPacchPred> trasportiPacchPred;
	
	public PacchPred() {
	}

	public PacchPred(PacchPredDTO pacchetto) {
		descrizione = pacchetto.getDescrizione();
		idPacchPred = pacchetto.getIdPacchPred();

	}

	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}