package compulsory.jdbcRepositories;


import compulsory.Database;
import compulsory.factories.DAOClasses;

import java.sql.*;

public class ArtistDAO implements DAOClasses {
    String name;

    public ArtistDAO() {

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void create() {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO artists (name) values (?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery("select id_artist from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement(); ResultSet rs = statement.executeQuery("SELECT name FROM artists WHERE id_artist='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
