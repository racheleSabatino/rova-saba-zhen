package it.polimi.traveldreamsystem.SessionBeans;

import java.util.Date;

import javax.ejb.Local;

@Local
public interface CheckDateLocal {

	boolean checkDate(Date data1, Date data2);

}
