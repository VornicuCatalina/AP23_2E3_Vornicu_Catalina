package bonus;

import java.sql.*;

public class PlaylistDAO {
    public void create(String name,String title) throws SQLException {
        Connection con = Database.getConnection();
        Array arrayTitle = con.createArrayOf("text", new String[]{title});
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO playlists (title,timestamp,albums) values (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setTimestamp(2,timestamp);
            preparedStatement.setArray(3, arrayTitle);
            preparedStatement.executeUpdate();
        }
    }

    public void create(String name,String[] title) throws SQLException {
        Connection con = Database.getConnection();
        Array arrayTitle = con.createArrayOf("text",title);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO playlists (title,timestamp,albums) values (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setTimestamp(2,timestamp);
            preparedStatement.setArray(3,arrayTitle);
            preparedStatement.executeUpdate();
        }
    }
}
