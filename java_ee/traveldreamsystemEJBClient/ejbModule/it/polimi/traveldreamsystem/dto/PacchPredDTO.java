package it.polimi.traveldreamsystem.dto;


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
	private List<ProdBaseDTO> prodBases1;
	private List<ProdBaseDTO> prodBases2;
	
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

	public List<ProdBaseDTO> getProdBases1() {
		return this.prodBases1;
	}

	public void setProdBases1(List<ProdBaseDTO> prodBases1) {
		this.prodBases1 = prodBases1;
	}

	public List<ProdBaseDTO> getprodBases2() {
		return this.prodBases2;
	}

	public void setProdBases2(List<ProdBaseDTO> prodBases2) {
		this.prodBases2 = prodBases2;
	}

	
}
