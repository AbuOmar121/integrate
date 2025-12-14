package org.example.service.impl;

import org.example.DAO.Interfaces.DepartmentDAOI;
import org.example.models.Department;
import org.example.service.Interfaces.DepartmentServiceI;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentServiceI {

    private DepartmentDAOI departmentDAO;

    public DepartmentServiceImpl(DepartmentDAOI departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int departmentId) {
        departmentDAO.deleteDepartment(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDAO.getDepartmentById(id);
    }
}
