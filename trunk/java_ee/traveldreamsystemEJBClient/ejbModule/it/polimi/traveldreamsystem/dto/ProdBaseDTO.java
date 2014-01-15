package it.polimi.traveldreamsystem.dto;

import java.util.List;

public class ProdBaseDTO {
	

		private int idProdBase;

		private int costo;

		private String descrizione;

		private EscursioneDTO escursione;

		private HotelDTO hotel;

		private PacchPerDTO pacchPer;

		private List<PacchPredDTO> pacchPreds1;

		private List<PacchPredDTO> pacchPreds2;

		private TrasportoDTO trasporto;

		public ProdBaseDTO() {
		}

		public int getIdProdBase() {
			return this.idProdBase;
		}

		public void setIdProdBase(int idProdBase) {
			this.idProdBase = idProdBase;
		}

		public int getCosto() {
			return this.costo;
		}

		public void setCosto(int costo) {
			this.costo = costo;
		}

		public String getDescrizione() {
			return this.descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		public EscursioneDTO getEscursione() {
			return this.escursione;
		}

		public void setEscursione(EscursioneDTO escursione) {
			this.escursione = escursione;
		}

		public HotelDTO getHotel() {
			return this.hotel;
		}

		public void setHotel(HotelDTO hotel) {
			this.hotel = hotel;
		}

		public PacchPerDTO getPacchPer() {
			return this.pacchPer;
		}

		public void setPacchPer(PacchPerDTO pacchPer) {
			this.pacchPer = pacchPer;
		}

		public List<PacchPredDTO> getPacchPreds1() {
			return this.pacchPreds1;
		}

		public void setPacchPreds1(List<PacchPredDTO> pacchPreds1) {
			this.pacchPreds1 = pacchPreds1;
		}

		public List<PacchPredDTO> getPacchPreds2() {
			return this.pacchPreds2;
		}

		public void setPacchPreds2(List<PacchPredDTO> pacchPreds2) {
			this.pacchPreds2 = pacchPreds2;
		}

		public TrasportoDTO getTrasporto() {
			return this.trasporto;
		}

		public void setTrasporto(TrasportoDTO trasporto) {
			this.trasporto = trasporto;
		}


}
