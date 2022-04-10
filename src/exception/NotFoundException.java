package exception;

public class NotFoundException extends Exception {


    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
