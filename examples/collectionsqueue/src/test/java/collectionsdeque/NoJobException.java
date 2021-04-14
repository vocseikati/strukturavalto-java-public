package collectionsdeque;

public class NoJobException extends Exception {

    String message;

    public NoJobException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
