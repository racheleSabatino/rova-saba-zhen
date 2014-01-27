package it.polimi.traveldreamsystem.dto;


public class PacchPerDTO {

	
	private int idPacchPer;

	private boolean listaRegali;
	
	private PacchPredDTO pacchPred;
	
	private UtenteDTO cliente;
	
	public PacchPerDTO() {
	}

	public PacchPerDTO(int idPacchPer, boolean listaRegali,
			PacchPredDTO pacchPred, UtenteDTO cliente) {
		this.idPacchPer = idPacchPer;
		this.listaRegali = listaRegali;
		this.pacchPred = pacchPred;
		this.cliente = cliente;
	}




	public int getIdPacchPer() {
		return idPacchPer;
	}


	public void setIdPacchPer(int idPacchPer) {
		this.idPacchPer = idPacchPer;
	}


	public boolean isListaRegali() {
		return listaRegali;
	}


	public void setListaRegali(boolean listaRegali) {
		this.listaRegali = listaRegali;
	}


	public PacchPredDTO getPacchPred() {
		return pacchPred;
	}


	public void setPacchPred(PacchPredDTO pacchPred) {
		this.pacchPred = pacchPred;
	}


	public UtenteDTO getCliente() {
		return cliente;
	}


	public void setCliente(UtenteDTO cliente) {
		this.cliente = cliente;
	}
}
