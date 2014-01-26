package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UserBean {
	private String newPsw1;
	private String oldPsw;
	private String newPsw2;
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;






	public UtenteMgrBeanLocal getUtenteMgrBean() {
		return utenteMgrBean;
	}

	public void setUtenteMgrBean(UtenteMgrBeanLocal utenteMgrBean) {
		this.utenteMgrBean = utenteMgrBean;
	}


	public String getName() {
		return utenteMgrBean.getUtenteDTO().getNome();
	}

	public String getMail() {
		return utenteMgrBean.getUtenteDTO().getMail();
	}


	public String getCognome() {
		return utenteMgrBean.getUtenteDTO().getCognome();
	}

	private String IsRoleImpiegato(String role) {
		UtenteDTO utenteDTO = utenteMgrBean.getUtenteDTO();

		if (utenteDTO != null
				&& utenteDTO.getTipoUtente().equals(role)) {
			return "true";
		}
		return "false";
	}
		
	public void changePassword(){
		if (newPsw1 == newPsw2 && (utenteMgrBean.getUtenteDTO()).getPassword() == oldPsw){
			
		}
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cambio avvenuto con successo"));  
	}

	public String getNewPsw1() {
		return newPsw1;
	}

	public void setNewPsw1(String newPsw1) {
		this.newPsw1 = newPsw1;
	}

	public String getOldPsw() {
		return oldPsw;
	}

	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}

	public String getNewPsw2() {
		return newPsw2;
	}

	public void setNewPsw2(String newPsw2) {
		this.newPsw2 = newPsw2;
	}

	public String getIsRoleCliente() {
		return IsRoleImpiegato("CLIENTE");
	}

	public String getIsRoleImpiegato() {
		return IsRoleImpiegato("IMPIEGATO");
	}

	public String getIsRoleAmministratore() {
		return IsRoleImpiegato("AMMINISTRATORE");
	}
}
