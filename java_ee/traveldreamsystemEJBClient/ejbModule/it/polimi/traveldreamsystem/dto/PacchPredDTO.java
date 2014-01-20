package it.polimi.traveldreamsystem.dto;


import java.util.ArrayList;
import java.util.List;




import org.hibernate.validator.constraints.NotEmpty;

public class PacchPredDTO {

	@NotEmpty
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private int idPacchPred;

	@NotEmpty
	private String descrizione;

	private List<PacchPerDTO> pacchPers;
	
	@NotEmpty
	private List<ProdBaseDTO> prodBases;
	
	
	
	public PacchPredDTO () {
		
	}
	
	public int getIdPacchPred() {
		return this.idPacchPred;
	}

	public void setIdPacchpred(int idPacchPred) {
		this.idPacchPred = idPacchPred;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<PacchPerDTO> getPacchPers() {
		return this.pacchPers;
	}

	public void setPacchPers(List<PacchPerDTO> pacchPers) {
		this.pacchPers = pacchPers;
	}

	public List<ProdBaseDTO> getProdBases() {
		return this.prodBases;
	}

	public void setProdBases(List<ProdBaseDTO> prodBases) {
		this.prodBases = prodBases;
	}

	
	
	
}
