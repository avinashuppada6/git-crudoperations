package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/myschema1";
    private static Connection conn;
    private static PreparedStatement pmst;

    public static void main(String[] args) {
        try {
            Scanner scr = new Scanner(System.in);
            
            // Load the MySQL driver
            Class.forName(Driver);
            
            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);
            
            // Prepare the SQL query
            String sql = "INSERT INTO decp11(name, email, password) VALUES (?, ?, ?)";
            pmst = conn.prepareStatement(sql);
            
            // Collect user inputs
            System.out.println("Enter name:");
            pmst.setString(1, scr.nextLine());
            
            System.out.println("Enter email:");
            pmst.setString(2, scr.nextLine());
            
            System.out.println("Enter password:");
            pmst.setString(3, scr.nextLine());
            
            // Execute the query
            int i = pmst.executeUpdate();
            if (i > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Error in data insertion.");
            }
            
            // Close resources
            pmst.close();
            conn.close();
            scr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

