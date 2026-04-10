package service;

import java.util.ArrayList;
import model.Household;
import myInterface.Registerable;

/*
 4.1.1 - HouseholdService updated to accept SystemReportService.
 Household count increments automatically on every successful registration.
 */

public class HouseholdService implements Registerable {

    private ArrayList<Household> households;

    // 4.1.1 - Reference to SystemReportService for automatic count updates
    private SystemReportService reportService;

    public HouseholdService(ArrayList<Household> households, SystemReportService reportService) {
        this.households = households;
        this.reportService = reportService;
    }

    @Override
    public void register() {
        System.out.println("Registering household...");
    }

    public void addHousehold(Household household) {
        households.add(household);
        // 4.1.1 - Household count updated automatically on every registration
        reportService.incrementHouseholds();
        household.register();
    }

    public boolean householdExists(int id) {
        for (Household h : households) {
            if (h.getId() == id) return true;
        }
        return false;
    }

    public ArrayList<Household> getHouseholds() { return households; }

    public Household getHouseholdById(int id) {
        for (Household h : households) {
            if (h.getId() == id) return h;
        }
        return null;
    }
}
