package exceptions;

public class ScreenAlreadyOccupiedException extends RuntimeException {
    public ScreenAlreadyOccupiedException(String message) {
        super(message);
    }

    public ScreenAlreadyOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
