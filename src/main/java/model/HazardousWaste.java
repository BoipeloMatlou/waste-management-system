package model;

/**
 * 2.1 - HazardousWaste subclass of WasteSubmission.
 * Contains its own logic for calculating the eco-impact score.
 * Hazardous waste has a GSP multiplier of 6.0 as it is toxic and dangerous to dispose.
 */
public class HazardousWaste extends WasteSubmission {

    // 2.1 - No-arg constructor
    public HazardousWaste() {}

    // 2.1 - Parameterised constructor, passes HAZARDOUS type to parent
    public HazardousWaste(String itemName, double itemWeight, int householdId) {
        super(itemName, WasteType.HAZARDOUS, itemWeight, householdId);
    }

    // 2.2.1 - Automatically applies the correct multiplier for hazardous waste
    // 2.2.2 - Score is calculated here so it can be displayed instantly on submission
    @Override
    public double calculateScore() {
        return getItemWeight() * 6.0;
    }
}
