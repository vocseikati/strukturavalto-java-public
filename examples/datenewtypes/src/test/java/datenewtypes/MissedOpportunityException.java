package datenewtypes;

public class MissedOpportunityException extends RuntimeException {

    private String message;

    public MissedOpportunityException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    //T360
    //public MissedOpportunityException(String message) {
    //        super(message);
    //    }

}
