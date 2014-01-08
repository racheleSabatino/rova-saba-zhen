package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	
	@EJB
	private UtenteMgrBeanLocal utenteMgrBean;
	
	public String getName() {
		return "Ciao " + utenteMgrBean.getUtenteDTO().getNome();
	}
}
