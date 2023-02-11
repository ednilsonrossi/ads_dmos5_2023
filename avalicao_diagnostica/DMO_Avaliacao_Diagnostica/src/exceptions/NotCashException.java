package exceptions;

public class NotCashException extends RuntimeException{

    public NotCashException(String message) {
        super(message);
    }

    public NotCashException(String message, Throwable cause) {
        super(message, cause);
    }

}
