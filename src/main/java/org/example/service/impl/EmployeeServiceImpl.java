package org.example.service.impl;

import org.example.BO.EmployeeBO;
import org.example.DAO.Interfaces.EmployeeDAOI;
import org.example.models.Employee;
import org.example.service.Interfaces.EmployeeServiceI;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeServiceI {

    private final EmployeeDAOI employeeDAO;

    public EmployeeServiceImpl(EmployeeDAOI employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
        EmployeeBO.validateForCreate(employee);
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeBO.validateForUpdate(employee);
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        EmployeeBO.validateId(id);
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        EmployeeBO.validateDepartmentId(departmentId);
        return employeeDAO.getEmployeesByDepartmentId(departmentId);
    }
}
