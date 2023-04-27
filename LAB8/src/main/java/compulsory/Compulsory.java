package compulsory;

import java.sql.SQLException;

public class Compulsory {
    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();

            //adding artists
            artists.create("Pink Floyd");
            artists.create("Michale Jackson");

            //committing the changes
            Database.getConnection().commit();

            //closing the DB
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
