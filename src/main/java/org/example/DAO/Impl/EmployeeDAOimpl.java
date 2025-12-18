package org.example.DAO.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DAO.Interfaces.EmployeeDAOI;
import org.example.Singletons.ConfigReader;
import org.example.Singletons.DatabaseConnection;
import org.example.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAOI {

    private static final ConfigReader properties = ConfigReader.getInstance();

    private static final Logger logger = LogManager.getLogger(EmployeeDAOimpl.class);

    private final Connection conn;


    public EmployeeDAOimpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = getString("E.add");
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
            logger.error("SQL Add Employee Error: {}", e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = getString("E.update");
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
            logger.error("SQL Update Employee Error: {}", e.getMessage());
        }
    }

    @Override
    public void updateEmployeeState(int id,int status,String result,boolean isRead) {
        String sql = getString("E.updateState");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, status);
            ps.setString(2, result);
            ps.setBoolean(3, isRead);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("SQL Update Employee State Error: {}", e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = getString("E.getAll");
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
            logger.error("SQL Get All Employee Error: {}", e.getMessage());
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = getString("E.getById");
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
            logger.error("SQL Get Employee By ID Error: {}", e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        List<Employee> employees = new ArrayList<>();
        String sql = getString("E.getByDepId");
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
            logger.error("SQL Get Employees By Department ID Error: {}", e.getMessage());
        }
        return employees;
    }

    public static String getString(String key)
    {
        return properties.getString(key);
    }

}
