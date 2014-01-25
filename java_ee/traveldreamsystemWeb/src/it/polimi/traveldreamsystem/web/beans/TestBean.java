package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.ImpiegatoMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TestBean {

	@EJB
	private EscursioneMgrBeanLocal escMgrLocal;
	@EJB
	private PacchPredMgrLocal pacchPredMgrBean;
	@EJB
	private ComposizPacchPredMgrLocal compPacchMgr;
	
	private List<EscursioneDTO> escursioni;

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

	public String a1() {
		PacchPredDTO pp = new PacchPredDTO();
		pp.setIdPacchPred(1);
		pp.setDescrizione("asd");
		pacchPredMgrBean.addNewPacchPred(pp);
		
		return "/test";
	}

	public String a2() {
		escursioni = compPacchMgr.getEscursioniPacchPred(1);
		return "/test";

	}
	
	public String a3() {
		compPacchMgr.findEscursione(1,1);
		
		return "/test";
		
	}

}
