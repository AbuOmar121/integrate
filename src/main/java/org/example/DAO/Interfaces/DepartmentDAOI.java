package org.example.DAO.Interfaces;

import org.example.models.Department;

import java.util.List;

public interface DepartmentDAOI {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int departmentId);
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
}
