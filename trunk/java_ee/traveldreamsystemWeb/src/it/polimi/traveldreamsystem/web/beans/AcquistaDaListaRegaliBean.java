package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import eccezioni.AcquistoProdDaPropriaLista;
import eccezioni.ProdottoGiaAcquistato;

@ManagedBean(name = "listaRegaliBean")
@RequestScoped
public class AcquistaDaListaRegaliBean {
	
	@EJB
	PacchPerMgrLocal pacchPerMgr;
	
	@EJB
	UtenteMgrBeanLocal utenteMgr;

	private PacchPerDTO pacchetto;
	
	private HotelDTO hotel;
	
	private EscursioneDTO escursione;
	
	private int idPacchPer;
	
	AcquistaDaListaRegaliBean(){
		if(pacchetto!=null)
			idPacchPer = pacchetto.getIdPacchPer();
	}
	
	public EscursioneDTO getEscursione() {
		return escursione;
	}

	public void setEscursione(EscursioneDTO escursione) {
		this.escursione = escursione;
	}

	public TrasportoDTO getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(TrasportoDTO trasporto) {
		this.trasporto = trasporto;
	}

	private TrasportoDTO trasporto;

	
	public void acquistaHotelDaListaRegali(int idProdBase) {
		String mail = utenteMgr.getPrincipalEmail();
		FacesContext messaggio = FacesContext.getCurrentInstance();
		try {
			pacchPerMgr.acquistaHotelListaRegali(idProdBase, idPacchPer, mail);
			messaggio.addMessage(null, new FacesMessage("Successo, acquisto terminato "));
		} catch (AcquistoProdDaPropriaLista a) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, non puoi comprare un singolo prodotto"
					+ "dalla tua lista regali, devi comprare tutto il pacchetto"));
		}
		catch(ProdottoGiaAcquistato p) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, il prodotto e' gia' stato acquistato"));
		}
	}
	
	public void acquistaEscursioneDaListaRegali(int idProdBase) {
		String mail = utenteMgr.getPrincipalEmail();
		FacesContext messaggio = FacesContext.getCurrentInstance();
		try {
			pacchPerMgr.acquistaEscursioneListaRegali(idProdBase, idPacchPer, mail);
			messaggio.addMessage(null, new FacesMessage("Successo, acquisto terminato "));
		} catch (AcquistoProdDaPropriaLista a) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, non puoi comprare un singolo prodotto"
					+ "dalla tua lista regali, devi comprare tutto il pacchetto"));
		}
		catch(ProdottoGiaAcquistato p) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, il prodotto e' gia' stato acquistato"));
		}
	}
	
	public void acquistaTrasportoDaListaRegali(int idProdBase) {
		String mail = utenteMgr.getPrincipalEmail();
		FacesContext messaggio = FacesContext.getCurrentInstance();
		try {
			pacchPerMgr.acquistaHotelListaRegali(idProdBase, idPacchPer, mail);
			messaggio.addMessage(null, new FacesMessage("Successo, acquisto terminato "));
		} catch (AcquistoProdDaPropriaLista a) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, non puoi comprare un singolo prodotto"
					+ "dalla tua lista regali, devi comprare tutto il pacchetto"));
		}
		catch(ProdottoGiaAcquistato p) {
			messaggio.addMessage(null, new FacesMessage("Attenzione, il prodotto e' gia' stato acquistato"));
		}
	}

	public PacchPerDTO getPacchetto() {
		return pacchetto;
	}

	public void setPacchetto(PacchPerDTO pacchetto) {
		this.pacchetto = pacchetto;
	}

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}
	
	

}
