package bonus;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin123";
    private static Connection connection = null;
    static HikariDataSource ds;

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
            createHikariCP();
            connection=ds.getConnection();
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

    //for HikariCP
    public static void createHikariCP(){
        HikariConfig config = new HikariConfig("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB8/src/main/java/optional/hikari.properties");
        ds = new HikariDataSource(config);
    }
}
