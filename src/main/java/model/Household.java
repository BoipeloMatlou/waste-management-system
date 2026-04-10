package model;

import myInterface.Registerable;

/*
The register() method provides the confirmation behaviour when a household
 is successfully added to the system via HouseholdService.
 */

public class Household implements Registerable {

    private int Id;
    private String contactNumber;
    private String householdName;
    private String address;

    public Household() {}

    public Household(int Id, String contactNumber, String householdName, String address) {
        this.Id = Id;
        this.contactNumber = contactNumber;
        this.householdName = householdName;
        this.address = address;
    }

    // 3.2.3 - Implementation of Registerable interface
    @Override
    public void register() {
        System.out.println("Household " + householdName + " registered successfully!");
    }

    public int getId() { return this.Id; }
    public String getContactNumber() { 
return this.contactNumber; }
    public String getHouseholdName() { 
return this.householdName; }
    public String getAddress() { 
return this.address; }

    public void setId(int Id) { 
this.Id = Id; }
    public void setContactNumber(String contactNumber) { 
this.contactNumber = contactNumber; }
    public void setHouseholdName(String householdName) { 
this.householdName = householdName; }
    public void setAddress(String address) { 
this.address = address; }
}
