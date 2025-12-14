package org.example.BO;

import org.example.models.Department;

public class DepartmentBO {
    public static String getFullDepartmentInfo(Department department) {
        return department.getName() + " (" + department.getAddress() + ")";
    }
}
