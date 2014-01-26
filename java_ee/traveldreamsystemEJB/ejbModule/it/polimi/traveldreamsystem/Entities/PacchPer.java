package it.polimi.traveldreamsystem.Entities;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PacchPer database table.
 * 
 */
@Entity
@Table(name="pacchPer")
@NamedQuery(name="PacchPer.findAll", query="SELECT p FROM PacchPer p")
public class PacchPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPACCHPER", unique=true, nullable=false)
	private int idPacchPer;

	@Column(name="LISTAREGALI", nullable=false, length=45)
	private boolean listaRegali;
	
	@ManyToOne
	@JoinColumn(name = "IDPACCHPRED", referencedColumnName = "IDPACCHPRED")
	private PacchPred pacchPred;

    @OneToMany(mappedBy="pacchPer")
    private List<HotelsPacchPer> hotelsPacchPer;

    @OneToMany(mappedBy="pacchPer")
    private List<EscursioniPacchPer> escursionePacchPer;

    @OneToMany(mappedBy="pacchPer")
    private List<TrasportiPacchPer> trasportiPacchPer;
    
	@ManyToOne
	@JoinColumn(name = "IDCLIENTE", referencedColumnName = "MAIL")
    private Utente cliente;
	
	public PacchPer() {}

	public PacchPer(PacchPerDTO newPacchetto) {
		this.idPacchPer = newPacchetto.getIdPacchPer();
		this.listaRegali = newPacchetto.getListaRegali();
		this.pacchPred.setIdPacchPred(newPacchetto.getIdPacchPer());
		this.cliente.setMail(newPacchetto.getMailCliente());
	}

	public int getIdPacchPer() {
		return idPacchPer;
	}

	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
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

	public List<HotelsPacchPer> getHotelsPacchPer() {
		return hotelsPacchPer;
	}

	public void setHotelsPacchPer(List<HotelsPacchPer> hotelsPacchPer) {
		this.hotelsPacchPer = hotelsPacchPer;
	}

	public List<EscursioniPacchPer> getEscursioniPacchPer() {
		return escursionePacchPer;
	}

	public void setEscursionePacchPer(List<EscursioniPacchPer> escursionePacchPer) {
		this.escursionePacchPer = escursionePacchPer;
	}

	public List<TrasportiPacchPer> getTrasportiPacchPer() {
		return trasportiPacchPer;
	}

	public void setTrasportiPacchPer(List<TrasportiPacchPer> trasportiPacchPer) {
		this.trasportiPacchPer = trasportiPacchPer;
	}

	public Utente getCliente() {
		return cliente;
	}

	public void setCliente(Utente cliente) {
		this.cliente = cliente;
	}
	
	public void getEsempio() {
		getHotelsPacchPer().get(1).getHotel().getCitta();
	}
	
}