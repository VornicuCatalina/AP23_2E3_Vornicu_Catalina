package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin123";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if(connection==null){
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void rollback() {
        try{
            connection.rollback();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
