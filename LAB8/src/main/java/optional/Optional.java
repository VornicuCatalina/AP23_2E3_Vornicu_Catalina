package optional;

import java.sql.SQLException;

public class Optional {
    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();

            //adding artists
            artists.create("Pink Floyd");
            artists.create("Michale Jackson");

            //committing the changes
            Database.getConnection().commit();

            //testing if it works
            //System.out.println(artists.findById(46));
            System.out.println(artists.findByName("Michale Jackson"));

            //adding genres
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");

            //committing the changes
            Database.getConnection().commit();

            //testing if it works
            //System.out.println(genres.findById(38));
            System.out.println(genres.findByName("Rock"));

            //adding albums
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            albums.create(1800, "TEST", "Sus", "Hip Hop");

            //testing if it works
            albums.findByName("The Wall");

            //committing the changes
            Database.getConnection().commit();

            //testing if the parsing works
            //ReadCSV readCSV=new ReadCSV("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB8/src/main/java/optional/test.csv");
            ReadCSV readCSV = new ReadCSV("C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB8/src/main/java/optional/albumlist.csv");

            //closing the DB
            Database.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
