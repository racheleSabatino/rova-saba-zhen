package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.ProdBaseDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the PacchPred database table.
 * 
 */
@Entity
@Table(name="pacchpred")
@NamedQuery(name="PacchPred.findAll", query="SELECT p FROM PacchPred p")
public class PacchPred implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDPACCHPRED", unique=true, nullable=false)
	private int idPacchPred;

	@Lob
	@Column(name="DESCRIZIONE")
	private String descrizione;

	//bi-directional many-to-one association to PacchPer
	@OneToMany(mappedBy="pacchPred")
	private List<PacchPer> pacchPers;

	//uni-directional many-to-many association to ProdBase
	@ManyToMany
	@JoinTable(
		name="composizione"		
		, joinColumns={		
			@JoinColumn(name="IDPACCHPRED", nullable=false)		
			}		
		, inverseJoinColumns={		
			@JoinColumn(name="IDPRODBASE", nullable=false)		
			}		
		)		
	private List<Hotel> hotel;

	public PacchPred() {
	}

	public PacchPred(PacchPredDTO pacchetto) {
		descrizione = pacchetto.getDescrizione();
		idPacchPred = pacchetto.getIdPacchPred();
		hotel = new ArrayList<Hotel>();
		//da rivedere
		for(int i=0; i<pacchetto.getProdBases().size(); i++) {
			HotelDTO hotelDTO = pacchetto.getProdBases().get(i);
			Hotel prodotto = new Hotel(hotelDTO);
			hotel.add(prodotto);
			
		}
	}

	public int getIdPacchPred() {
		return this.idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<PacchPer> getPacchPers() {
		return this.pacchPers;
	}

	public void setPacchPers(List<PacchPer> pacchPers) {
		this.pacchPers = pacchPers;
	}

	public PacchPer addPacchPer(PacchPer pacchPer) {
		getPacchPers().add(pacchPer);
		pacchPer.setPacchPred(this);

		return pacchPer;
	}

	public PacchPer removePacchPer(PacchPer pacchPer) {
		getPacchPers().remove(pacchPer);
		pacchPer.setPacchPred(null);

		return pacchPer;
	}
    
}