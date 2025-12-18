package org.example.DAO.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.DAO.Interfaces.DepartmentDAOI;
import org.example.Singletons.ConfigReader;
import org.example.Singletons.DatabaseConnection;
import org.example.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartmentDAOimpl implements DepartmentDAOI
{

    private static final ConfigReader properties = ConfigReader.getInstance();

    private static final Logger logger = LogManager.getLogger(DepartmentDAOimpl.class);

    private final Connection conn;

    public DepartmentDAOimpl() {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = properties.getString("D.get");
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                departments.add(new Department(
                        rs.getInt("d_id"),
                        rs.getString("d_name"),
                        rs.getString("d_address")
                ));
            }
        } catch (SQLException e) {
            logger.error("SQL Get Departments Error: {}", e.getMessage());
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(int id) {
        String sql = properties.getString("D.getDepById");
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
            logger.error("SQL Get Department By ID Error: {}", e.getMessage());
        }
        return null;
    }

    public String getDepartmentNameById(int id)
    {
        String sql = properties.getString("D.getDepNamById");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("d_name");
                }
            }
        } catch (SQLException e) {
            logger.error("SQL Get Department Name By ID Error: {}", e.getMessage());
        }
        return null;
    }
}

