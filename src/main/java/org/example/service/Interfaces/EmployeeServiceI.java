package org.example.service.Interfaces;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeServiceI
{
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee getEmployee(int id);
    List <Employee> getAllEmployees();
}
