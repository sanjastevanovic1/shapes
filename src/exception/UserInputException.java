package exception;

public class UserInputException extends Exception{

    public UserInputException(String message) {
        System.out.println("Wrong input:");
    }

    @Override
    public String getMessage() {
        System.out.print("Wrong input: ");
        return super.getMessage();
    }

    public UserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
