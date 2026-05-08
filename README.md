# waste-management-system
A Java console application for managing household waste submissions, collectors, and recycling data — built using multi-package OOP architecture.

📋 Description
>A progressively developed waste management system built across 5 deliverables as part of my Java programming coursework at Eduvos. The system allows households to submit waste, classifies it by type, validates inputs, calculates scores, and generates reports.

📁 Project Structure
>src/
>
>├── model/
>
>     ├── Household.java
>
>     ├── Collector.java
>
>     ├── WasteSubmission.java
>
>     ├── PlasticWaste.java
>
>     ├── OrganicWaste.java
>
>     └── HazardousWaste.java
>
>├── service/
>
>     ├── InputValidator.java
>
>     ├── WasteService.java
>
>     ├── HouseholdService.java
>
>     └── ReportService.java
>
>├── exception/
>
>     ├── InvalidWeightException.java
>
>     ├── InvalidWasteTypeException.java
>
>     ├── HouseholdNotFoundException.java
>
>     └── InvalidFieldException.java
>
>└── main/
>
>      └── Main.java
----------------------------------------------
✨ Features
>Register households and collectors

>Submit waste by type (Plastic, Organic, Hazardous)

>Validates all inputs — weight, waste type, and field values

>Calculates household recycling scores

>Weight conversion utility (kg to tons)

>Report generation for system statistics

>Full menu-driven console interface

🛠️ Built With
>Language: Java | Platform: Standard Java Console Application

🚀 How to Run
>Clone the repository

>Open in IntelliJ IDEA, Eclipse, or any Java IDE

>Compile from the src folder

>Run main/Main.java

💡 Concepts Demonstrated
>Multi-package Java project architecture

>Inheritance and polymorphism (WasteSubmission base class with PlasticWaste, OrganicWaste, HazardousWaste subclasses)

>Enums for waste type classification

>Custom exceptions

>Service layer architecture

>Input validation

>Static utility methods
------------------------------------------------
👤 Author:
Boipelo Matlou — Computer Science Student at Eduvos, Midrand
