package exception;

/**
 * 5.1.3 - InvalidFieldException (exception package).
 * Custom exception thrown when a required input field is left empty.
 * Used by InputValidator.validateField() to ensure all fields are
 * completed before an action is processed.
 */

public class InvalidFieldException extends Exception {
    public InvalidFieldException(String message) {
        super(message);
    }
}
