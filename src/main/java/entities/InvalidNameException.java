package entities;

/**
 * Izuzetak koji se baca kada je ime neispravno.
 *
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }

    public InvalidNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNameException(Throwable cause) {
        super(cause);
    }

    public InvalidNameException() {
    }
}
