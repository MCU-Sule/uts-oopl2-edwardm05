package com.example.utspbol_1872003_edwardmichaels.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//1872003 - Edward Michael S
public class JDBCConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SquidDB",
                    "root",
                    "edwardm05"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
