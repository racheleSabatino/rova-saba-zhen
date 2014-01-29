package eccezioni;

public class ProdottoGiaAcquistato extends Exception {

	private static final long serialVersionUID = -8172090142767779098L;

	public ProdottoGiaAcquistato(String messaggio) {
		super(messaggio);
	}
}
