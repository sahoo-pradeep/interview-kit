package design_patterns.structural_patterns.p1_adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employeeFromDB =
                new EmployeeDB("1001", "John", "Cena", "jc@www");

        EmployeeLdap employeeLdap =
                new EmployeeLdap("1002", "Henry", "Mark", "mh@wwe");

        EmployeeLdapAdapter employeeLdapAdapter = new EmployeeLdapAdapter(employeeLdap);

        EmployeeCsv employeeCsv = new EmployeeCsv("1003,Stone,Cold,sc@www");
        EmployeeCsvAdapter employeeCsvAdapter =
                new EmployeeCsvAdapter(employeeCsv);

        employees.add(employeeFromDB);
        employees.add(employeeLdapAdapter);
        employees.add(employeeCsvAdapter);

        return employees;
    }
}
