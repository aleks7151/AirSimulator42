package simulator;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException(String error) {
        super(error);
    }
}
