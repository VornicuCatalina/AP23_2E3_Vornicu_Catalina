package compulsory;

import java.sql.*;

public class ArtistDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO artists (name) values (?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT id_artist FROM artists WHERE name='" + name + "'"
             )) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT name FROM artists WHERE id_artist='" + id + "'"
             )) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
