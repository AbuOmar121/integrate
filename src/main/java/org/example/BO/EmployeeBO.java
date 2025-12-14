package org.example.BO;

import org.example.models.Employee;
import org.example.models.Department;

public class EmployeeBO {
    public static String integrateEmployeeDetails(Employee employee, Department department) {
        return employee.getFirstName() + " " + employee.getLastname() + " - " + department.getName();
    }
}
