package com.employee.EmployeeManagementSystem;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
@Component
public class DatabaseConnectionChecker {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void testDatabaseConnection() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn != null) {
                DatabaseMetaData metaData = conn.getMetaData();
                System.out.println("✅ Database connected successfully!");
                System.out.println("🔹 Database URL: " + metaData.getURL());
                System.out.println("🔹 Database Name: " + metaData.getDatabaseProductName());
                System.out.println("🔹 Database Version: " + metaData.getDatabaseProductVersion());
                System.out.println("🔹 Driver Name: " + metaData.getDriverName());
            } else {
                System.out.println("❌ Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Database connection error: " + e.getMessage());
        }
    }

}
