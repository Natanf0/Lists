package exceptions;

public class NotFoundException extends EmptyListException {
    int index;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int index) {
        this.index = index;
    }
    public int getIndex() {return this.index;}
}
