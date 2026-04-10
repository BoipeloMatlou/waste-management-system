package myInterface;

import java.util.ArrayList;
import model.Household;

/*
Defines the generateReport() behaviour for service classes
 that produce eco-impact summaries. Implemented by WasteService.
 */

public interface Reportable {
    void generateReport(ArrayList<Household> households);
}
