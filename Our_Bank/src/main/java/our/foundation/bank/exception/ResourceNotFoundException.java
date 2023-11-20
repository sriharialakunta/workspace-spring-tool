package our.foundation.bank.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String string) {
		 super(string+" not Found");
	}


}
