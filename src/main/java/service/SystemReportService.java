package service;

import model.WasteSubmission;
import util.WeightConverter;

/*
Centralised class that tracks and stores all real-time system-wide statistics.
 All metrics update automatically whenever relevant operations occur in the system.
 */

public class SystemReportService {

    // 4.1.1 - Tracks total number of registered households
    private int totalHouseholds;

    // 4.1.3 - Tracks total number of registered collectors
    private int totalCollectors;

    // 4.1.2 - Tracks cumulative waste weight per category (kg)
    private double plasticWeight;
    private double organicWeight;
    private double hazardousWeight;

    // 4.1.4 - Tracks cumulative GSP eco-impact score per category
    private double plasticGSP;
    private double organicGSP;
    private double hazardousGSP;

    public SystemReportService() {
        this.totalHouseholds = 0;
        this.totalCollectors = 0;
        this.plasticWeight = 0;
        this.organicWeight = 0;
        this.hazardousWeight = 0;
        this.plasticGSP = 0;
        this.organicGSP = 0;
        this.hazardousGSP = 0;
    }

    // 4.1.1 - Called automatically in HouseholdService.addHousehold()
    public void incrementHouseholds() { totalHouseholds++; }

    // 4.1.3 - Called automatically in case 2 of Main when a collector is registered
    public void incrementCollectors() { totalCollectors++; }

    // 4.1.2 & 4.1.4 - Called automatically in WasteService.addSubmission()
    // Updates weight and GSP per category based on the submitted waste type
    public void updateWasteStats(WasteSubmission wasteSubmission) {
        double weight = wasteSubmission.getItemWeight();
        double score = wasteSubmission.calculateScore();

        switch (wasteSubmission.getWasteType()) {
            case PLASTIC:
                plasticWeight += weight;
                plasticGSP += score;
                break;
            case ORGANIC:
                organicWeight += weight;
                organicGSP += score;
                break;
            case HAZARDOUS:
                hazardousWeight += weight;
                hazardousGSP += score;
                break;
        }
    }

    // 4.1 - Displays the full system report in a clear, user-friendly format
    public void displayReport() {
        double totalWeight = plasticWeight + organicWeight + hazardousWeight;
        double totalGSP = plasticGSP + organicGSP + hazardousGSP;

        System.out.println("\n========== GreenTrack System Report ==========\n"
                // 4.1.1 - Total registered households
                + "Total Registered Households : " + totalHouseholds + "\n"
                // 4.1.3 - Total registered collectors
                + "Total Registered Collectors : " + totalCollectors + "\n"
                // 4.1.2 - Waste weight by category in kg and tons
                + "\n---- Waste Weight by Category ----\n"
                + "Plastic   : " + plasticWeight + " kg (" + WeightConverter.kgToTons(plasticWeight) + " tons)\n"
                + "Organic   : " + organicWeight + " kg (" + WeightConverter.kgToTons(organicWeight) + " tons)\n"
                + "Hazardous : " + hazardousWeight + " kg (" + WeightConverter.kgToTons(hazardousWeight) + " tons)\n"
                + "Total     : " + totalWeight + " kg (" + WeightConverter.kgToTons(totalWeight) + " tons)\n"
                // 4.1.4 - Eco-impact GSP score by category
                + "\n---- Eco-Impact Score (GSP) by Category ----\n"
                + "Plastic   : " + plasticGSP + " GSP\n"
                + "Organic   : " + organicGSP + " GSP\n"
                + "Hazardous : " + hazardousGSP + " GSP\n"
                + "Total GSP : " + totalGSP + " GSP\n"
                + "==============================================\n");
    }
}
