package exception;

public class fileException extends Exception{


    public fileException(String message) {
        super(message);
    }

    public fileException(String message, Throwable cause) {
        super(message, cause);
    }


}
