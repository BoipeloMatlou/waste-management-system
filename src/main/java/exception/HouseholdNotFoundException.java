package exception;

/*
 Custom exception thrown when a waste submission references
 a household ID that has not been registered in the system.
 */

public class HouseholdNotFoundException extends Exception {
    public HouseholdNotFoundException(String message) {
        super(message);
    }
}
