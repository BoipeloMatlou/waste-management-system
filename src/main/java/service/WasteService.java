package service;

import java.util.ArrayList;
import model.Household;
import model.WasteSubmission;
import myInterface.Reportable;

/*
4.1.2 & 4.1.4 - WasteService updated to accept SystemReportService.
Waste stats (weight and GSP per category) update automatically on every submission.
 */
public class WasteService implements Reportable {

    private ArrayList<WasteSubmission> wasteItem;

    // 4.1.2 & 4.1.4 - Reference to SystemReportService for automatic stat updates
    private SystemReportService reportService;

    public WasteService(ArrayList<WasteSubmission> wasteItem, SystemReportService reportService) {
        this.wasteItem = wasteItem;
        this.reportService = reportService;
    }

    public void addSubmission(WasteSubmission wasteSubmission) {
        wasteItem.add(wasteSubmission);
        // 4.1.2 & 4.1.4 - Weight and GSP stats updated automatically on every submission
        reportService.updateWasteStats(wasteSubmission);
    }

    public boolean hasSubmissions() { return !wasteItem.isEmpty(); }

    public ArrayList<WasteSubmission> getWasteItem() { return wasteItem; }

    public double getTotalGSPForHousehold(int householdId) {
        double total = 0;
        for (WasteSubmission w : wasteItem) {
            if (w.getHouseholdId() == householdId) total += w.calculateScore();
        }
        return total;
    }

    @Override
    public void generateReport(ArrayList<Household> households) {
        if (!hasSubmissions()) {
            System.out.println("No waste submissions to calculate eco-impact for.");
        } else {
            System.out.println("\n------- Eco-Impact Report -------");
            for (Household h : households) {
                System.out.println("\nHousehold: " + h.getHouseholdName());
                for (WasteSubmission w : wasteItem) {
                    if (w.getHouseholdId() == h.getId()) {
                        double score = w.calculateScore();
                        System.out.println("  Item: " + w.getItemName()
                                + " | Type: " + w.getWasteType()
                                + " | Weight: " + w.getItemWeight() + " kg"
                                + " | GSP: " + score);
                    }
                }
                System.out.println("  Total GSP for " + h.getHouseholdName()
                        + ": " + getTotalGSPForHousehold(h.getId()) + "\n");
            }
        }
    }
    
    // Gets all submissions for a specific household
    public ArrayList<WasteSubmission> getSubmissionsForHousehold(int householdId) {
        ArrayList<WasteSubmission> result = new ArrayList<>();
        for (WasteSubmission w : wasteItem) {
            if (w.getHouseholdId() == householdId) {
                result.add(w);
            }
        }
        return result;
}
}
