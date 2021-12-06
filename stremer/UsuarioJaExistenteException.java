package stremer;

public class UsuarioJaExistenteException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioJaExistenteException(String msg) {
		super(msg);
	}
}