package it.polimi.traveldreamsystem.SessionBeans;

import java.util.List;

import it.polimi.traveldreamsystem.dto.PacchPerDTO;
import it.polimi.traveldreamsystem.dto.PacchPredDTO;

import javax.ejb.Local;

import eccezioni.PacchettoScadutoException;

@Local
public interface PacchPerMgrLocal {

	void addNewPacchPer(PacchPerDTO newPacchetto);

	void acquistaPacchPer(int idPacchPer) throws PacchettoScadutoException;

	void creaListaRegali(int idPacchPer);

	List<PacchPerDTO> getClientePacchPerDTONonAcquistati(String mail);

	void acquistaEscursioneListaRegali(int idEscursione, int idPacchPer, String mailAcquirente);

	void acquistaTrasportoListaRegali(int idTrasporto, int idPacchPer, String mailAcquirente);

	void acquistaHotelListaRegali(int idHotel, int idPacchPer,
			String mailAcquirente);

	int viewCostoTotale(int idPacchPer);

	List<PacchPerDTO> getAllPacchPer();

	PacchPerDTO findPacchPerDTO(int idPacchPer);

	void update(PacchPerDTO pacchetto);

	void removePacchPer(int idPacchPer);

	List<PacchPerDTO> getClientePacchPerDTOAcquistati(String mail);

	int viewTotaleAcquistatoDaAmici(int idPacchPer);


}
