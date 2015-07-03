package bo.ihm.exceptions;

public class BoIHMException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = -86431296144201395L;

    public BoIHMException() {
        super();
    }

    public BoIHMException(final String message) {
        super(message);
    }

    public BoIHMException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BoIHMException(final Throwable cause) {
        super(cause);
    }

}
