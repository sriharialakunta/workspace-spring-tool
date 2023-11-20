package our.foundation.bank.exception;

public class MethodArgumentNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public MethodArgumentNotValidException(String string) {
		 super(string+" not Found");
	}


}
