package main.webapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectionAccess {
    private String user = "kitty";
    private String password = "purrrrrr";
    private String url = "jdbc:postgresql://localhost/cats";

    public Connection makeConnection() {

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }


}
