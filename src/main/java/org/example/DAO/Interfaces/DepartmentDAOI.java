package org.example.DAO.Interfaces;

import org.example.models.Department;

import java.util.List;

public interface DepartmentDAOI {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    String getDepartmentNameById(int id);
}
