package bonus;

import java.sql.SQLException;

public class Bonus {
    public static void main(String[] args) throws SQLException {
        //var playlists=new PlaylistDAO();
        //playlists.create("test","Some title");

        var maximal=new MaximalPlaylist();

       // Database.getConnection().commit();
        System.out.println("\nSQL Version:\n");
        maximal.testSQL();
    }
}
