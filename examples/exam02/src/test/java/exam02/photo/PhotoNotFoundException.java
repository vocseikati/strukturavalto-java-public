package exam02.photo;

public class PhotoNotFoundException extends IllegalArgumentException {

    public PhotoNotFoundException(String message) {
        super(message);
    }
}
