package org.example.Singletons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DatabaseConnection
{
    private static final ConfigReader properties = ConfigReader.getInstance();
    private static final Logger logger = LogManager.getLogger(DatabaseConnection.class);
    private static Connection con;

    DatabaseConnection()
    {
        try
        {
            String url = properties.getString("db.url");
            String user = properties.getString("db.user");
            String pass = properties.getString("db.password");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e)
        {
            logger.error("SQL Connection Error: {}", e.getMessage());
        }
    }

    public static Connection getConnection()
    {
        return con;
    }
}
