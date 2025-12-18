package org.example.BO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.Employee;

public class EmployeeBO {

    private static final Logger logger =
            LogManager.getLogger(EmployeeBO.class);

    private EmployeeBO() {}

    public static void validateForCreate(Employee employee) {

        if (employee == null) {
            logger.error("Employee validation failed: employee object is null");
            return;
        }

        if (employee.getFirstName() == null || employee.getFirstName().trim().isEmpty()) {
            logger.error("Employee validation failed: first name is empty");
        }

        if (employee.getLastname() == null || employee.getLastname().trim().isEmpty()) {
            logger.error("Employee validation failed: last name is empty");
        }

        if (employee.getSalary() < 0) {
            logger.error(
                    "Employee validation failed: negative salary {}",
                    employee.getSalary()
            );
        }

        if (employee.getDepartmentId() <= 0) {
            logger.error(
                    "Employee validation failed: invalid department ID {}",
                    employee.getDepartmentId()
            );
        }
    }

    public static void validateForUpdate(Employee employee) {
        validateForCreate(employee);
        if (employee != null && employee.getId() <= 0) {
            logger.error(
                    "Employee update validation failed: invalid employee ID {}",
                    employee.getId()
            );
        }
    }

    public static void validateId(int id) {
        if (id <= 0) {
            logger.error("Employee fetch failed: invalid employee ID {}", id);
        }
    }

    public static void validateDepartmentId(int departmentId) {
        if (departmentId <= 0) {
            logger.error(
                    "Employee fetch failed: invalid department ID {}",
                    departmentId
            );
        }
    }
}
