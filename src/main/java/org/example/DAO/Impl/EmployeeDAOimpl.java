package org.example.DAO.Impl;

import org.example.DAO.Interfaces.EmployeeDAOI;
import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAOI {

    private Connection conn;

    public EmployeeDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (E_FirstName, E_LastName, E_salary, E_status, E_result, is_read, d_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastname());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getStatus());
            ps.setString(5, employee.getResult());
            ps.setBoolean(6, employee.isIsread());
            ps.setInt(7, employee.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET E_FirstName = ?, E_LastName = ?, E_salary = ?, E_status = ?, E_result = ?, is_read = ?, d_id = ? WHERE e_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastname());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getStatus());
            ps.setString(5, employee.getResult());
            ps.setBoolean(6, employee.isIsread());
            ps.setInt(7, employee.getDepartmentId());
            ps.setInt(8, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employee WHERE e_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("e_id"),
                        rs.getString("E_FirstName"),
                        rs.getString("E_LastName"),
                        rs.getDouble("E_salary"),
                        rs.getInt("E_status"),
                        rs.getString("E_result"),
                        rs.getBoolean("is_read"),
                        rs.getInt("d_id")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE e_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("e_id"),
                            rs.getString("E_FirstName"),
                            rs.getString("E_LastName"),
                            rs.getDouble("E_salary"),
                            rs.getInt("E_status"),
                            rs.getString("E_result"),
                            rs.getBoolean("is_read"),
                            rs.getInt("d_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE d_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("e_id"),
                            rs.getString("E_FirstName"),
                            rs.getString("E_LastName"),
                            rs.getDouble("E_salary"),
                            rs.getInt("E_status"),
                            rs.getString("E_result"),
                            rs.getBoolean("is_read"),
                            rs.getInt("d_id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
