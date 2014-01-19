package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.dto.ProdBaseDTO;

import javax.ejb.Local;

@Local
public interface ProdBaseMgrLocal {

	void addNewProdBase(ProdBaseDTO newProdotto);

	void removeProdBase(int idProdBase);

	ProdBaseDTO findProdBasedDTO(int idProdBase);

}
