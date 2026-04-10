package util;

/*
Provides reusable static helper methods for unit conversion.
*/

public class WeightConverter {

    // 3.1.3 - Converts kilograms to metric tons
    public static double kgToTons(double kg) {
        return kg / 1000.0;
    }

    // 3.1.3 - Converts metric tons back to kilograms
    public static double tonsToKg(double tons) {
        return tons * 1000.0;
    }
}

