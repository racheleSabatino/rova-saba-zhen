package it.polimi.traveldreamsystem.web.beans;

import java.util.Date;

import it.polimi.traveldreamsystem.SessionBeans.UtenteMgrBeanLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userBean")
@RequestScoped
public class ProdBaseBean {
	private String tipo;
	private Date dataPartenza;

	public Date getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public void changePanel(){
		
	}
}
