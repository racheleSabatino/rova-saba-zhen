package it.polimi.traveldreamsystem.SessionBeans;

import java.util.List;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;

import javax.ejb.Local;

@Local
public interface PacchPerMgrLocal {

	void addNewPacchPer(PacchPerDTO newPacchetto);

	void acquistaPacchPer(int idPacchPer);

	void creaListaRegali(int idPacchPer);

	List<PacchPerDTO> getClientePacchPerDTONonACquistati(String mail);

	List<PacchPerDTO> getClientePacchPerDTOACquistati(String mail);

	int acquistaEscursioneListaRegali(int idEscursione, int idPacchPer, String mailAcquirente);

	int acquistaTrasportoListaRegali(int idTrasporto, int idPacchPer, String mailAcquirente);

	int acquistaHotelListaRegali(int idHotel, int idPacchPer,
			String mailAcquirente);

	int viewCostoTotale(int idPacchPer);

}
