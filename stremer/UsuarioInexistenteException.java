package stremer;

public class UsuarioInexistenteException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioInexistenteException(String msg) {
		super(msg);
	}
}