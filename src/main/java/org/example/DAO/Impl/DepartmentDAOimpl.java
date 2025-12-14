package org.example.DAO.Impl;

import org.example.DAO.Interfaces.DepartmentDAOI;
import org.example.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOimpl implements DepartmentDAOI {

    private Connection conn;

    public DepartmentDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addDepartment(Department department) {
        String sql = "INSERT INTO department (d_name, d_address) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department) {
        String sql = "UPDATE department SET d_name = ?, d_address = ? WHERE d_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getAddress());
            ps.setInt(3, department.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int departmentId) {
        String sql = "DELETE FROM department WHERE d_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                departments.add(new Department(
                        rs.getInt("d_id"),
                        rs.getString("d_name"),
                        rs.getString("d_address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(int id) {
        String sql = "SELECT * FROM department WHERE d_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Department(
                            rs.getInt("d_id"),
                            rs.getString("d_name"),
                            rs.getString("d_address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
