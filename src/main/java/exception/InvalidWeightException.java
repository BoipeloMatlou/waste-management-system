package exception;

/*
Custom exception thrown when a user submits a negative or non-numeric weight.
Used by InputValidator.validateWeight() in the util package.
 */

public class InvalidWeightException extends Exception {
    public InvalidWeightException(String message) {
        super(message);
    }
}
