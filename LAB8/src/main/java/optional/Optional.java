package optional;
import java.sql.SQLException;

public class Optional {
    public static void main(String[] args) {
        try{
            var artists=new ArtistDAO();

            //adding artists
            artists.create("Pink Floyd");
            artists.create("Michale Jackson");

            //committing the changes
            compulsory.Database.getConnection().commit();

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
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");

            //testing if it works
            albums.findByName("The Wall");

            //committing the changes
            Database.getConnection().commit();

            //closing the DB
            Database.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
