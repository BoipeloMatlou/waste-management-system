package myInterface;

/*
Defines a customisable register() behaviour that can be implemented
by any class that represents a registerable entity in the system.
Both Household and Collector implement this interface.
 */

public interface Registerable {
    void register();
}
