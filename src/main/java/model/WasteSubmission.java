package model;

/*
 2.1 - WasteSubmission refactored into an abstract class.
 This allows the system to recognise and process different waste types
 using different logic for each, satisfying the requirement for
 polymorphic behaviour per waste type.
 */

public abstract class WasteSubmission {

    // 2.1 - Enum for waste type classification
    public enum WasteType { PLASTIC, ORGANIC, HAZARDOUS }

    // 2.1 - Instance variables
    private String itemName;
    private WasteType wasteType;
    private double itemWeight;
    private int householdId;

    // 2.1 - No-arg constructor
    public WasteSubmission() {}

    // 2.1 - Parameterised constructor
    public WasteSubmission(String itemName, WasteType wasteType, double itemWeight, int householdId) {
        this.itemName = itemName;
        this.wasteType = wasteType;
        this.itemWeight = itemWeight;
        this.householdId = householdId;
    }

    // 2.2.1 - Abstract method forces each subclass to implement its own score logic
    // This ensures the correct multiplier is applied automatically per waste type
    public abstract double calculateScore();

    // 2.1 - Getters
    public String getItemName() { return this.itemName; }
    public WasteType getWasteType() { return this.wasteType; }
    public double getItemWeight() { return this.itemWeight; }
    public int getHouseholdId() { return this.householdId; }

    // 2.1 - Setters
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setWasteType(WasteType wasteType) { this.wasteType = wasteType; }
    public void setItemWeight(double itemWeight) { this.itemWeight = itemWeight; }
    public void setHouseholdId(int householdId) { this.householdId = householdId; }
}
