package org.example.service.impl;

import org.example.BO.DepartmentBO;
import org.example.DAO.Interfaces.DepartmentDAOI;
import org.example.models.Department;
import org.example.service.Interfaces.DepartmentServiceI;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentServiceI
{

    private final DepartmentDAOI departmentDAO;

    public DepartmentServiceImpl(DepartmentDAOI departmentDAO)
    {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> getAllDepartments()
    {
        DepartmentBO.validateGetAll();
        return departmentDAO.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int id)
    {
        DepartmentBO.validateId(id);
        return departmentDAO.getDepartmentById(id);
    }

    @Override
    public String getDepartmentNameById(int id)
    {
        DepartmentBO.validateId(id);
        return departmentDAO.getDepartmentNameById(id);
    }
}
