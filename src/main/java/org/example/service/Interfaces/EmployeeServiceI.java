package org.example.service.Interfaces;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeServiceI {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesByDepartmentId(int departmentId);
}
