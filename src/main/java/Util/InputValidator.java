package util;

import exception.InvalidWeightException;
import exception.InvalidWasteTypeException;
import exception.InvalidFieldException;

/*
 InputValidator updated with full validation coverage.
 All validation methods use custom exceptions from the exception package
 to prevent invalid data from being processed.
 */
public class InputValidator {

    // ID validation 
    public static int validateId(String input) throws NumberFormatException {
        int id = Integer.parseInt(input.trim());
        if (id < 0) throw new NumberFormatException("ID cannot be negative.");
        return id;
    }

    // Prevents negative weight submissions
    public static double validateWeight(String input) throws InvalidWeightException {
        try {
            double weight = Double.parseDouble(input.trim());
            if (weight < 0)
                throw new InvalidWeightException("Weight cannot be negative. Please enter a positive number.");
            return weight;
        } catch (NumberFormatException e) {
            throw new InvalidWeightException("Invalid weight. Please enter a number.");
        }
    }

    // Prevents unrecognised or unsupported waste type selections
    public static int validateWasteType(String input) throws InvalidWasteTypeException {
        try {
            int selection = Integer.parseInt(input.trim());
            if (selection < 1 || selection > 3)
                throw new InvalidWasteTypeException("Invalid selection. Please choose 1, 2, or 3.");
            return selection;
        } catch (NumberFormatException e) {
            throw new InvalidWasteTypeException("Invalid input. Please enter a number.");
        }
    }

    // Ensures all required text fields are completed before processing
    public static String validateField(String input, String fieldName) throws InvalidFieldException {
        if (input == null || input.trim().isEmpty())
            throw new InvalidFieldException(fieldName + " cannot be empty. Please try again.");
        return input.trim();
    }
}
