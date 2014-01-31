package eccezioni;

public class ErroreException extends Exception {

	private static final long serialVersionUID = -8172090142767779098L;

	public ErroreException(String messaggio) {
		super(messaggio);
	}
}
