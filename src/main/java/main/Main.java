package main;

import java.util.ArrayList;
import java.util.Scanner;
import exception.HouseholdNotFoundException;
import exception.InvalidWeightException;
import exception.InvalidWasteTypeException;
import model.Household;
import model.Collector;
import model.WasteSubmission;
import model.PlasticWaste;
import model.OrganicWaste;
import model.HazardousWaste;
import service.HouseholdService;
import service.WasteService;
import service.SystemReportService;
import util.InputValidator;
import util.WeightConverter;
import exception.InvalidFieldException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        ArrayList<Household> households = new ArrayList<>();
        ArrayList<Collector> collectors = new ArrayList<>();
        ArrayList<WasteSubmission> wasteItem = new ArrayList<>();

        // 4.1 - SystemReportService initialised and passed into both service classes 
        SystemReportService reportService = new SystemReportService();
        HouseholdService householdService = new HouseholdService(households, reportService);
        WasteService wasteService = new WasteService(wasteItem, reportService);

        while (run) {
            // 4.1 - Menu updated to include option 6 for the system report
            System.out.println("-------Green Track System-------\n"
                    + "0 - Exit\n"
                    + "1 - Register a new household\n"
                    + "2 - Register a waste collector\n"
                    + "3 - Submit waste entries\n"
                    + "4 - View all waste submissions\n"
                    + "5 - Calculate eco-impact\n"
                    + "6 - View system report\n");
            System.out.print("Select a choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {


                // 3.1.1 - Case 1 delegates to HouseholdService
                // 5.1.3 - Case 1: All household fields validated before the household is processed
                case 1: {
                    Household household = new Household();
                    boolean validId = false;

                    while (!validId) {
                        System.out.print("Enter the household ID: ");
                        try {
                            household.setId(InputValidator.validateId(scanner.nextLine()));
                            validId = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a whole number.");
                        }
                    }

                    // 5.1.3 - Name field cannot be empty
                    boolean validName = false;
                    while (!validName) {
                        System.out.print("Enter the Head of household name: ");
                        try {
                            household.setHouseholdName(InputValidator.validateField(scanner.nextLine(), "Name"));
                            validName = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    // 5.1.3 - Contact number field cannot be empty
                    boolean validContact = false;
                    while (!validContact) {
                        System.out.print("Enter the contact number: ");
                        try {
                            household.setContactNumber(InputValidator.validateField(scanner.nextLine(), "Contact number"));
                            validContact = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    // 5.1.3 - Address field cannot be empty
                    boolean validAddress = false;
                    while (!validAddress) {
                        System.out.print("Enter the physical address: ");
                        try {
                            household.setAddress(InputValidator.validateField(scanner.nextLine(), "Address"));
                            validAddress = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    householdService.addHousehold(household);
                    break;
                }

                // 5.1.3 - Case 2: All collector fields validated before the collector is processed
                case 2: {
                    Collector collector = new Collector();
                    boolean validId = false;

                    while (!validId) {
                        System.out.print("Enter the collector's ID: ");
                        try {
                            collector.setId(InputValidator.validateId(scanner.nextLine()));
                            validId = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a whole number.");
                        }
                    }

                    // 5.1.3 - Name field cannot be empty
                    boolean validName = false;
                    while (!validName) {
                        System.out.print("Enter the collector's name: ");
                        try {
                            collector.setName(InputValidator.validateField(scanner.nextLine(), "Name"));
                            validName = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    // 5.1.3 - Service area field cannot be empty
                    boolean validArea = false;
                    while (!validArea) {
                        System.out.print("Enter the service area: ");
                        try {
                            collector.setServiceArea(InputValidator.validateField(scanner.nextLine(), "Service area"));
                            validArea = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    collectors.add(collector);
                    reportService.incrementCollectors();
                    collector.register();
                    break;
                }

                // 5.1.1, 5.1.2, 5.1.3 - Case 3: Full validation on all waste submission fields
                case 3: {
                    String itemName = "";

                    // 5.1.3 - Item name cannot be empty
                    boolean validName = false;
                    while (!validName) {
                        System.out.print("Enter the item name: ");
                        try {
                            itemName = InputValidator.validateField(scanner.nextLine(), "Item name");
                            validName = true;
                        } catch (InvalidFieldException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    double weight = 0;
                    boolean validWeight = false;
                    while (!validWeight) {
                        System.out.print("Enter the item weight (kg): ");
                        try {
                            // 5.1.1 - Negative weights prevented via InvalidWeightException
                            weight = InputValidator.validateWeight(scanner.nextLine());
                            validWeight = true;
                        } catch (InvalidWeightException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    int householdId = 0;
                    boolean validHouseholdId = false;
                    while (!validHouseholdId) {
                        System.out.print("Enter your household ID: ");
                        try {
                            householdId = InputValidator.validateId(scanner.nextLine());
                            if (householdService.householdExists(householdId)) {
                                validHouseholdId = true;
                            } else {
                                throw new HouseholdNotFoundException("Household ID not found. Please register the household first.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a whole number.");
                        } catch (HouseholdNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    WasteSubmission wasteSubmission = null;
                    boolean validType = false;
                    while (!validType) {
                        System.out.println("Select the waste type:\n"
                                + "1 - Plastic\n2 - Organic\n3 - Hazardous\n");
                        System.out.print("Selection: ");
                        try {
                            // 5.1.2 - Unsupported waste types prevented via InvalidWasteTypeException
                            int selection = InputValidator.validateWasteType(scanner.nextLine());
                            switch (selection) {
                                case 1: wasteSubmission = new PlasticWaste(itemName, weight, householdId); 
                                    validType = true; 
                                    break;
                                case 2: wasteSubmission = new OrganicWaste(itemName, weight, householdId); 
                                    validType = true; 
                                    break;
                                case 3: wasteSubmission = new HazardousWaste(itemName, weight, householdId); 
                                    validType = true; 
                                    break;
                            }
                        } catch (InvalidWasteTypeException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    wasteService.addSubmission(wasteSubmission);
                    System.out.println("Waste entry submitted successfully!\n"
                            + "GSP Score for this item: " + wasteSubmission.calculateScore() + "\n"
                            + "Weight in tons: " + WeightConverter.kgToTons(wasteSubmission.getItemWeight()));
                    break;
                }


                case 4: {
                    if (!wasteService.hasSubmissions()) {
                        System.out.println("There are currently no submissions.");
                    } else {
                        for (Household h : householdService.getHouseholds()) {
                            ArrayList<WasteSubmission> householdSubmissions = wasteService.getSubmissionsForHousehold(h.getId());
                            if (!householdSubmissions.isEmpty()) {
                                System.out.println("Household ID: " + h.getId() + ", Name: " + h.getHouseholdName());
                                System.out.println("  Waste Submissions:");
                                for (WasteSubmission w : householdSubmissions) {
                                    System.out.println("  - " + w.getWasteType() + ": " + w.getItemName()
                                            + " (" + w.getItemWeight() + " kg) "
                                            + "\u2192 Impact: " + w.calculateScore() + " GSP");
                                }
                                System.out.println();
                            }
                        }
                    }
                    break;
                }
                case 5: { 
                    wasteService.generateReport(households); 
                    break; }

                // 4.1 - Case 6: View System Report
                case 6: {
                    reportService.displayReport();
                    break;
                }

                case 0: {
                    System.out.println("Exiting Green Track System...");
                    run = false;
                    break;
                }

                default: {
                    System.out.println("Invalid input! Please try again.");
                }
            }
        }
    }
}
