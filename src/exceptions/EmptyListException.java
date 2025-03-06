package exceptions;

public class EmptyListException extends MyException {
    public EmptyListException(String message) {
        super(message);
    }
    public EmptyListException() {}
}
