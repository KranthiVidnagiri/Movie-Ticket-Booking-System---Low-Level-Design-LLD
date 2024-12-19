package exceptions;

public class SeatPermanentlyUnavailableException extends RuntimeException {
    public SeatPermanentlyUnavailableException(String message) {
        super(message);
    }

    public SeatPermanentlyUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
