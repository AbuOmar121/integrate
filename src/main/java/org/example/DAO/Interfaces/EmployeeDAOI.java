package org.example.DAO.Interfaces;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeDAOI {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void updateEmployeeState(int id,int status,String result,boolean isRead);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesByDepartmentId(int departmentId);
}
