package exceptions;

public class SeatTemporaryUnavailableException extends RuntimeException {
    public SeatTemporaryUnavailableException(String message) {
        super(message);
    }

    public SeatTemporaryUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
