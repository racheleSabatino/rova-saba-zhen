package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.TrasportoDTO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TrasportoMgrBeanLocal {

	void addNewTrasporto(TrasportoDTO newTrasporto);

	void removeTrasporto(int idTrasporto);

	TrasportoDTO findTrasportoDTO(int idTrasporto);

	List<TrasportoDTO> getAllTrasporto();

	void update(TrasportoDTO trasporto);

	String pagRiepilogoPacchPer(int idTrasporto);

	boolean checkToFrom(List<TrasportoDTO> list);

}
