package eccezioni;

public class AcquistoProdDaPropriaLista extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcquistoProdDaPropriaLista(String messaggio) {
		super(messaggio);
	}
}
