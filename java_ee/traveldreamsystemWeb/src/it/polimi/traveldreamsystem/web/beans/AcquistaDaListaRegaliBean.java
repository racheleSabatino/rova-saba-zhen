package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eccezioni.AcquistoProdDaPropriaLista;
import eccezioni.ProdottoGiaAcquistato;

@ManagedBean(name = "listaRegaliBean")
@RequestScoped
public class AcquistaDaListaRegaliBean {
	
	@EJB
	PacchPerMgrLocal pacchPerMgr;
	
	private int idProdBase;
	
	private int idPacchPer;

	public int getIdProdBase() {
		return idProdBase;
	}

	public void setIdProdBase(int idProdBase) {
		this.idProdBase = idProdBase;
	}

	public int getIdPacchPer() {
		return idPacchPer;
	}

	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}
	
	public void acquistaHotelDaListaRegali(int idProdBase) {
		try {
			pacchPerMgr.acquistaHotelListaRegali(idProdBase, idPacchPer, "gr");
		} catch (AcquistoProdDaPropriaLista | ProdottoGiaAcquistato e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
