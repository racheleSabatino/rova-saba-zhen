package it.polimi.traveldreamsystem.dto;


import java.util.List;



import org.hibernate.validator.constraints.NotEmpty;

public class PacchPredDTO {

	@NotEmpty
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private int idpacchpred;

	@NotEmpty
	private String descrizione;

	//contiene la lista degli id dei pacchetti personalizzati a cui è associato
	private List<Integer> idPacchPers;
	
	@NotEmpty
	private List<Integer> idProdBases1;
	private List<Integer> idProdBases2;
	
	public int getIdpacchpred() {
		return this.idpacchpred;
	}

	public void setIdpacchpred(int idpacchpred) {
		this.idpacchpred = idpacchpred;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Integer> getIdPacchPers() {
		return this.idPacchPers;
	}

	public void setPacchPers(List<Integer> idPacchPers) {
		this.idPacchPers = idPacchPers;
	}

	public List<Integer> getIdProdBases1() {
		return this.idProdBases1;
	}

	public void setProdBases1(List<Integer> idProdBases1) {
		this.idProdBases1 = idProdBases1;
	}

	public List<Integer> getIdProdBases2() {
		return this.idProdBases2;
	}

	public void setProdBases2(List<Integer> idProdBases2) {
		this.idProdBases2 = idProdBases2;
	}

	
}
