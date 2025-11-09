package entities;

public class NegativeNumException extends RuntimeException {
    public NegativeNumException() {
        super("Upisan negativan broj");
    }

    public NegativeNumException(String message) {
        super(message);
    }

    public NegativeNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeNumException(Throwable cause) {
        super(cause);
    }
}
