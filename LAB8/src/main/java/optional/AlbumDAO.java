package optional;

import java.sql.*;

public class AlbumDAO {
    private int numberGenres = 0;

    public void countGenres() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT count(distinct name)+1 from genres"
             )) {
            numberGenres = rs.next() ? rs.getInt(1) : null;
        }
    }

    public void create(int release_year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(
                "INSERT INTO albums (release_year,title,artist,genre) values (?,?,?,?)")) {
            preparedStatement.setInt(1, release_year);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, artist);
            preparedStatement.setString(4, genre);
            preparedStatement.executeUpdate();

            //adding in associative table too
            int id_album;
            int id_genre;
            countGenres();

            //getting the ids
            try (Statement statement = con.createStatement();
                 ResultSet rs = statement.executeQuery(
                         "SELECT id_album FROM albums WHERE title='" + title + "'"
                 )) {
                id_album = rs.next() ? rs.getInt(1) : null;
            }
            try (PreparedStatement preparedStatement1 = con.prepareStatement(
                    "INSERT INTO associative (id_album,id_genre) values(?,?)"
            )) {
                preparedStatement1.setInt(1, id_album);
                int counter = 0;
                int numberGenreParameter = 0;
                String[] arrayHelp;

                //breaking genre in more genres because of comma
                if (genre.contains(",")) {
                    arrayHelp = new String[numberGenres];
                    arrayHelp = genre.split(",");
                    numberGenreParameter = arrayHelp.length;
                    while (counter < numberGenreParameter) {
                        try (Statement statement = con.createStatement();
                             ResultSet rs = statement.executeQuery(
                                     "SELECT id_genre FROM genres WHERE name='" + arrayHelp[counter] + "'"
                             )) {
                            id_genre = rs.next() ? rs.getInt(1) : null;
                        }
                        preparedStatement1.setInt(2, id_genre);
                        preparedStatement1.executeUpdate();
                        counter++;
                    }
                } else {
                    //if there is only one genre
                    try (Statement statement = con.createStatement();
                         ResultSet rs = statement.executeQuery(
                                 "SELECT id_genre FROM genres WHERE name='" + genre + "'"
                         )) {
                        id_genre = rs.next() ? rs.getInt(1) : null;
                    }
                    preparedStatement1.setInt(2, id_genre);
                    preparedStatement1.executeUpdate();
                }

            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT id_album FROM albums WHERE title='" + name + "'"
             )) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT title FROM albums WHERE id_album='" + id + "'"
             )) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
