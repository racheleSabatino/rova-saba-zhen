package it.polimi.traveldreamsystem.dto;


public class PacchPerDTO {

	
	private int idPacchPer;

	private boolean listaRegali;
	
	private int idPacchPred;
	
	private String mailCliente;
	
	public PacchPerDTO() {
	}

	public int getIdpacchper() {
		return this.idPacchPer;
	}

	public void setIdpacchper(int idpacchper) {
		this.idPacchPer = idpacchper;
	}

	public boolean getListaRegali() {
		return this.listaRegali;
	}

	public void setListaRegali(boolean listaRegali) {
		this.listaRegali = listaRegali;
	}

	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getMailCliente() {
		return mailCliente;
	}

	public void setMailCliente(String mailCliente) {
		this.mailCliente = mailCliente;
	}

	

}
