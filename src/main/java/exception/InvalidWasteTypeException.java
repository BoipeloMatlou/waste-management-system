package exception;

/*
Custom exception thrown when a user selects an unsupported waste type.
Used by InputValidator.validateWasteType() in the util package.
 */

public class InvalidWasteTypeException extends Exception {
    public InvalidWasteTypeException(String message) {
        super(message);
    }
}
