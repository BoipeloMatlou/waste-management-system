package model;

import myInterface.Registerable;

/*
The register() method provides the confirmation behaviour when a collector
 is successfully added to the system.
 */

public class Collector implements Registerable {

    private int Id;
    private String name;
    private String serviceArea;

    public Collector() {}

    public Collector(int Id, String name, String serviceArea) {
        this.Id = Id;
        this.name = name;
        this.serviceArea = serviceArea;
    }

    // 3.2.3 - Implementation of Registerable interface
    @Override
    public void register() {
        System.out.println("Collector " + name + " registered successfully!");
    }

    public int getId() { 
return this.Id; }
    public String getName() { 
return this.name; }
    public String getServiceArea() { 
return this.serviceArea; }

    public void setId(int Id) { 
this.Id = Id; }
    public void setName(String name) { 
this.name = name; }
    public void setServiceArea(String serviceArea) { 
this.serviceArea = serviceArea; }
}
