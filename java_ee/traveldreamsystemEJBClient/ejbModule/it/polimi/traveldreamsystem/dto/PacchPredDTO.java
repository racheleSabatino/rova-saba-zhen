package it.polimi.traveldreamsystem.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class PacchPredDTO {

	@NotEmpty
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private int idPacchPred;

	private String descrizione;
	
	public PacchPredDTO () {
	}

	public PacchPredDTO(int id) {
		idPacchPred = id;
		descrizione = new String(" ");
	}

	public int getIdPacchPred() {
		return idPacchPred;
	}

	public void setIdPacchPred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
