package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.List;

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
	private PacchPredMgrLocal pacchPredMgr;
	@EJB
	private EscursioneMgrBeanLocal escMgrLocal;

	public String a1() {
		PacchPredDTO pp = new PacchPredDTO();
		pp.setIdPacchPred(1);
		pp.setDescrizione("asd");
		pacchPredMgr.addNewPacchPred(pp);
		return "/test";
	}

	public String a2() {
		PacchPredDTO pp = pacchPredMgr.getAllPacchPred().get(0);
		EscursioneDTO ee = escMgrLocal.getAllEscursione().get(0);
		List<EscursioneDTO> eel = new ArrayList<EscursioneDTO>();
		eel.add(ee);
		pp.setEscursione(eel);
		pacchPredMgr.update(pp);
		return "/test";
	}

}
