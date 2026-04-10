package model;

/**
 * 2.1 - OrganicWaste subclass of WasteSubmission.
 * Contains its own logic for calculating the eco-impact score.
 * Organic waste has a GSP multiplier of 0.5 as it is biodegradable and low harm.
 */
public class OrganicWaste extends WasteSubmission {

    // 2.1 - No-arg constructor
    public OrganicWaste() {}

    // 2.1 - Parameterised constructor, passes ORGANIC type to parent
    public OrganicWaste(String itemName, double itemWeight, int householdId) {
        super(itemName, WasteType.ORGANIC, itemWeight, householdId);
    }

    // 2.2.1 - Automatically applies the correct multiplier for organic waste
    // 2.2.2 - Score is calculated here so it can be displayed instantly on submission
    @Override
    public double calculateScore() {
        return getItemWeight() * 0.5;
    }
}
