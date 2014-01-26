package it.polimi.traveldreamsystem.dto;


public class PacchPerDTO {

	
	private int idPacchPer;

	private boolean listaRegali;
	
	private int idPacchPred;
	
	private String mailCliente;
	
	public PacchPerDTO() {
	}

	public int getIdPacchPer() {
		return this.idPacchPer;
	}

	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
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
