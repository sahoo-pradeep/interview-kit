package kit.interview.design_patterns.solid_principles;

// Single Responsibility Principle: A class should have just one reason to change.
// Class should responsible for single functionality.
// Goal: reduce complexity
public class P1SingleResponsibility {

    // Employee class can change when:
    // (1) we need to add more Employee related fields.
    // (2) when we need to change the time sheet format -> Too much responsibility. Move this.
    private static class EmployeeV1 {
        String name;
        String department;

        public String getTimeSheet(){
            return name + "TimeSheetFormatted";
        }
    }

    private static class EmployeeV2 {
        String name;
        String department;
    }

    // Create a new class for Time sheet related functionality
    private static class TimeSheet {
        public String print(EmployeeV2 employeeV2){
            return employeeV2.name + "TimeSheetFormatted";
        }
    }
}
