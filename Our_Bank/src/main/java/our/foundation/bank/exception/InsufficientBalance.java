package our.foundation.bank.exception;

public class InsufficientBalance extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public InsufficientBalance(String string) {
		 super(string+" not Found");
	}


}
