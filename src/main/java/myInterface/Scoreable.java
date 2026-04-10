package myInterface;

/*
Defines the calculateScore() behaviour for waste submission types.
 Implemented by the abstract WasteSubmission class, which enforces
 each subclass (PlasticWaste, OrganicWaste, HazardousWaste) to provide
 its own scoring implementation.
 */

public interface Scoreable {
    double calculateScore();
}
