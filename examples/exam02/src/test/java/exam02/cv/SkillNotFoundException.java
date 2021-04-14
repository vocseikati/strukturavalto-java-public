package exam02.cv;

public class SkillNotFoundException extends RuntimeException {

    String message;

    public SkillNotFoundException(String message) {
        super(message);

    }
}
