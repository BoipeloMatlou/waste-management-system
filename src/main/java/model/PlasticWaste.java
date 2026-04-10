package model;

/**
 * 2.1 - PlasticWaste subclass of WasteSubmission.
 * Contains its own logic for calculating the eco-impact score.
 * Plastic has a GSP multiplier of 3.0 due to long-lasting pollution.
 */
public class PlasticWaste extends WasteSubmission {

    // 2.1 - No-arg constructor
    public PlasticWaste() {}

    // 2.1 - Parameterised constructor, passes PLASTIC type to parent
    public PlasticWaste(String itemName, double itemWeight, int householdId) {
        super(itemName, WasteType.PLASTIC, itemWeight, householdId);
    }

    // 2.2.1 - Automatically applies the correct multiplier for plastic waste
    // 2.2.2 - Score is calculated here so it can be displayed instantly on submission
    @Override
    public double calculateScore() {
        return getItemWeight() * 3.0;
    }
}
