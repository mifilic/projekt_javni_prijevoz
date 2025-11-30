package entities.Exceptions;

/**
 * Izuzetak koji se baca kada su godine neispravno upisane.
 *
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public class InvalidNumException extends Exception {
    public InvalidNumException() {
        super("Krivo upisane godine.");
    }

    public InvalidNumException(String message) {
        super(message);
    }

    public InvalidNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumException(Throwable cause) {
        super(cause);
    }
}
