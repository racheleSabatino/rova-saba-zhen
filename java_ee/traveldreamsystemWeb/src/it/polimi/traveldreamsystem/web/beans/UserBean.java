package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean {

	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;

	public String getName() {
		return utenteMgrBean.getUtenteDTO().getNome();
	}

	private String IsRoleImpiegato(String role) {
		UtenteDTO utenteDTO = utenteMgrBean.getUtenteDTO();

		if (utenteDTO != null
				&& utenteDTO.getTipoUtente().equals(role)) {
			return "true";
		}
		return "false";
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
