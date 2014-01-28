package eccezioni;

public class PacchettoScadutoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PacchettoScadutoException(String messaggio){
		super(messaggio);
	}

}
