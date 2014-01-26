package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.ImpiegatoMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;
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
	
	private String date;
	

	@EJB
	private EscursioneMgrBeanLocal escursioneMgrBean;

	public String a1() {
		PacchPredDTO pp = new PacchPredDTO();
		pp.setIdPacchPred(1);
		pp.setDescrizione("asd");
		pacchPredMgrBean.addNewPacchPred(pp);
		setDate(new String());
		return "/test";
	}

	public String a2() {
		compPacchMgr.getEscursioniPacchPred(1);
		return "/test";

	}
	
	public String a3() {
		compPacchMgr.findEscursione(1,1);
		return "/test";
		
	}
	
	public String a4() {
		compPacchMgr.removeEscursioneToPacch(1,1);
		return "/test";
	}
	
	public String a6(){
		compPacchMgr.addTrasportoToPacch(1, 1);
		return "/test";
	}
	
	public String a5(){
		TrasportoDTO t = new TrasportoDTO();
		t.setIdProdBase(1);
		t.setCittaPartenza("Roma");
		t.setCittaRitorno("maldive");
		t.setCosto(200);
		Date d = new Date("2010,12,31"); 
		t.setDataPartenza("d");
		this.compPacchMgr.getDatePacch(1);
		return null;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
