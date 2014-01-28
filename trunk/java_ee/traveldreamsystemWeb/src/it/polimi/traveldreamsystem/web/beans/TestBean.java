package it.polimi.traveldreamsystem.web.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.ComposizPacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.EscursioneMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.ImpiegatoMgrBeanLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPerMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.PacchPredMgrLocal;
import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.EscursioneDTO;
import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;
import it.polimi.traveldreamsystem.dto.TrasportoDTO;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
public class TestBean {

	@EJB
	private EscursioneMgrBeanLocal escMgrLocal;
	@EJB
	private PacchPredMgrLocal pacchPredMgrBean;
	@EJB
	private ComposizPacchPredMgrLocal compPacchMgr;
	@EJB
	private UtenteMgrBeanLocal utenteMgr;
	@EJB
	private ComposizPacchPerMgrLocal compPacchPer;
	@EJB
	private PacchPerMgrLocal pacchPerMgr;
	
	private String date;
	
	private String citta;
	
	private List<PacchPredDTO> pacchetti;
	
	private List<Integer> idPacchPred;
	

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
	
	public String a5(){
		TrasportoDTO t = new TrasportoDTO();
		t.setIdProdBase(1);
		t.setCittaPartenza("Roma");
		t.setCittaRitorno("maldive");
		t.setCosto(200);
		Calendar cal = Calendar.getInstance(); 
		cal.set(Calendar.YEAR, 2014); 
		cal.set(Calendar.MONTH, 1); 
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		Date dateRepresentation = cal.getTime();
		t.setDataPartenza(dateRepresentation);
		t.setDataRitorno(dateRepresentation);
		t.setDescrizione("volo business");
		compPacchMgr.addTrasportoToPacch(1, 1);
		return "/test";
	}
	
	public String a6(){
		date = this.compPacchMgr.getDatePacch(1);
		setCitta(this.compPacchMgr.getCittaPartenzaPacch(1));
		return null;
	}
	
	public String a7(){
		pacchetti = pacchPredMgrBean.getAllPacchPred();
		setPacchetti(this.pacchPredMgrBean.getAllPacchPred());
		List<Integer> ids = new ArrayList<Integer>();
		for(int i=0; i < pacchetti.size(); i++) {
			ids.add(pacchetti.get(i).getIdPacchPred());
		}
		setIdPacchPred(ids);
		return null;
	}
	
	public String a8(){
		return "/creazionePacchPer?faces-redirect=true&amp;id=1";
	}
	
	public String a9(){
		PacchPredDTO pp = new PacchPredDTO();
		pp.setIdPacchPred(3);
		pp.setDescrizione("pacchetto per testare a9");
		pacchPredMgrBean.addNewPacchPred(pp);
		PacchPerDTO pacchPer = new PacchPerDTO();
		UtenteDTO utente = new UtenteDTO();
		utente.setMail("rachele");
		utente.setCognome("sabatino");
		utente.setNome("rachele");
		utente.setPassword("rachele91");
		pacchPer.setCliente(utente);
		pacchPer.setIdPacchPer(100);
		pacchPer.setListaRegali(false);
		pacchPer.setPacchPred(pp);
		return null;
	}
	
	public String a10() {
		pacchPerMgr.viewCostoTotale(3);
		return null;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<PacchPredDTO> getPacchetti() {
		return pacchetti;
	}

	public void setPacchetti(List<PacchPredDTO> pacchetti) {
		this.pacchetti = pacchetti;
	}

	public List<Integer> getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(List<Integer> idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

}
