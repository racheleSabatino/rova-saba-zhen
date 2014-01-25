package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean {
	private boolean pswPanelVisible = false;
	private String psw1;
	private String psw2;
	private String newPsw;
	
	

	public boolean isPswPanelVisible() {
		return pswPanelVisible;
	}

	public void setPswPanelVisible(boolean pswPanelVisible) {
		this.pswPanelVisible = pswPanelVisible;
	}

	public String getPsw1() {
		return psw1;
	}

	public void setPsw1(String psw1) {
		this.psw1 = psw1;
	}

	public String getPsw2() {
		return psw2;
	}

	public void setPsw2(String psw2) {
		this.psw2 = psw2;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

	public UtenteMgrBeanLocal getUtenteMgrBean() {
		return utenteMgrBean;
	}

	public void setUtenteMgrBean(UtenteMgrBeanLocal utenteMgrBean) {
		this.utenteMgrBean = utenteMgrBean;
	}

	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;

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
	
	public void showPasswordPanel(){
		pswPanelVisible = true;
	}
	
	public void changePassword(){
		
		pswPanelVisible = false;
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
