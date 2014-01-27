package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.EscursioneDTO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface EscursioneMgrBeanLocal {

	void addNewEscursione(EscursioneDTO newEscursione);

	void removeEscursione(int idEscursione);

	EscursioneDTO findEscursioneDTO(int idEscursione);

	List<EscursioneDTO> getAllEscursione();

	void update(EscursioneDTO escursione);

	String pagRiepilogoPacchPer(int idEscursione);

}
