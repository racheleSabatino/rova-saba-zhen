package it.polimi.traveldreamsystem.SessionBeans;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CheckDate
 */
@Stateless
@LocalBean
public class CheckDate implements CheckDateLocal {

    /**
     * Default constructor. 
     */
    public CheckDate() {
       
    }
    
    @Override
    public boolean checkDate(Date data1, Date data2) {
    	if(data2.after(data1) || data2.equals(data1)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
