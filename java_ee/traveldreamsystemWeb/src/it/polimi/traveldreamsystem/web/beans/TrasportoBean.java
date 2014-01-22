package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.HotelMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.TrasportoMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.HotelDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TrasportoBean {

	@EJB
	private TrasportoMgrBeanLocal trasportoMgrBean;

	private TrasportoDTO trasporto;
	
	public TrasportoBean() {
		trasporto = new TrasportoDTO();
	}

	public void addTrasporto(){
		trasportoMgrBean.addNewTrasporto(trasporto);
	}

	public TrasportoDTO getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(TrasportoDTO trasporto) {
		this.trasporto = trasporto;
	}
	
}
