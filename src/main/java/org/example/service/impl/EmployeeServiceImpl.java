package org.example.service.impl;

import org.example.DAO.Interfaces.EmployeeDAOI;
import org.example.models.Employee;
import org.example.service.Interfaces.EmployeeServiceI;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeServiceI {

    private EmployeeDAOI employeeDAO;

    public EmployeeServiceImpl(EmployeeDAOI employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employeeDAO.getEmployeesByDepartmentId(departmentId);
    }
}
