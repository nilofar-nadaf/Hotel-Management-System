package hotel.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel_management_system",
                    "root",
                    "YOUR_MYSQL_PASSWORD");

            // Create Statement
            s = c.createStatement();

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}