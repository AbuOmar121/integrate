package org.example.BO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.Department;

public final class DepartmentBO
{

    private static final Logger logger =
            LogManager.getLogger(DepartmentBO.class);

    private DepartmentBO() {}

    public static void validateGetAll() {
    }

    // Validate get by ID
    public static void validateId(int id) {
        if (id <= 0) {
            logger.error("Department validation failed: invalid department ID {}", id);
        }
    }

    public static void validateDepartment(Department department) {

        if (department == null) {
            logger.error("Department validation failed: department object is null");
            return;
        }

        if (department.getName() == null || department.getName().trim().isEmpty()) {
            logger.error("Department validation failed: department name is empty");
        }

        if (department.getAddress() == null || department.getAddress().trim().isEmpty()) {
            logger.error("Department validation failed: department address is empty");
        }
    }
}
