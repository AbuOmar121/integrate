package org.example.service.Interfaces;

import org.example.models.Department;

import java.util.List;

public interface DepartmentServiceI {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    String getDepartmentNameById(int id);
}
