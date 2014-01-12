package it.polimi.traveldreamsystem.web.beans;

import it.polimi.traveldreamsystem.SessionBeans.AddNewEmployee;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="addEmployeeBean")
@RequestScoped
public class AddEmployeeBean {

	@EJB
	private AddNewEmployee addEmployee;
		
	private UtenteDTO employee;
		
	public AddEmployeeBean() {
			this.employee = new UtenteDTO();
		}
		
		public void add() {
			addEmployee.addNewEmployee(employee);
		}
		
		public UtenteDTO getCurrent() {
			return employee;
		}
		
		public void setCurrent(UtenteDTO employee) {
			this.employee = employee;
		}
		
}
