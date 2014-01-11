package it.polimi.traveldreamsystem.web.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public String processImpiegato(){
		return "success";
	}
 
	public String processAmmin(){
		return "success";
	}
	
    private final static String URL_PATTERN = "[A-Za-z0-9?=.]*";
    private final static Pattern URL_COMPILED_PATTERN = Pattern.compile(URL_PATTERN);
    
	public String getTrimUrl(String url) {
		
        Matcher matcher = URL_COMPILED_PATTERN.matcher(url);

        if(matcher.matches()) {
        	return url;
        }
        else {
        	return "/pageNotFound";
        }
		
	}
}