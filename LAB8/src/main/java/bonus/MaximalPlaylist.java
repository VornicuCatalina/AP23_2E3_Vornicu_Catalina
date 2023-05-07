package bonus;

import optional.Database;
import org.jgrapht.Graph;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.sql.*;
import java.util.*;

public class MaximalPlaylist {
    private Graph<Integer, DefaultEdge> graphJGraphT;
    private ArrayList<Integer> idsList; //array for the graph
    private ArrayList<String> titles;
    private Map<Integer, ArrayList<Integer>> connectionPlaylist; //id_album & albums connected to it

    //the number of neighbors in an arraylist
    private ArrayList<Integer> numberOfNeighbors;

    private int numberAlbums() {
        //connection
        Connection con = Database.getConnection();

        //variable
        int number;

        //getting number of items
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT COUNT(*) FROM albums"
             )) {
            number = rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return number;
    }

    public MaximalPlaylist() throws SQLException {
        //connection
        Connection con = Database.getConnection();

        //creating the attributes
        graphJGraphT = new DefaultUndirectedGraph<>(DefaultEdge.class);
        idsList = new ArrayList<>();
        titles = new ArrayList<>();
        connectionPlaylist = new HashMap<>();

        //local variables
        int ids;
        String name;

        //creating the graph using albums' id
        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT id_album,title FROM albums"
             )) {
            while (rs.next()) {
                ids = rs.getInt(1);
                name = rs.getString(2);
                idsList.add(ids);
                titles.add(name);
                graphJGraphT.addVertex(ids);
            }
        }

        //now for creating the edges
        //connecting them using 3 cases: year, artist and genre

        //the case for the same year / artist
        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT a1.id_album,a2.id_album " +
                             "FROM albums a1 CROSS JOIN albums a2 " +
                             "WHERE a1.id_album>a2.id_album AND " +
                             "( a1.release_year = a2.release_year OR a1.artist=a2.artist);"
             )) {
            int id1, id2;
            while (resultSet.next()) {
                id1 = resultSet.getInt(1);
                id2 = resultSet.getInt(2);
                if (!graphJGraphT.containsEdge(id1, id2)) {
                    graphJGraphT.addEdge(id1, id2);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //the case for the same genre
        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT a1.id_album,a2.id_album " +
                             "FROM associative a1 CROSS JOIN associative a2 " +
                             "WHERE a1.id_album>a2.id_album AND a1.id_genre=a2.id_genre; "
             )) {
            int id1, id2;
            while (resultSet.next()) {
                id1 = resultSet.getInt(1);
                id2=resultSet.getInt(2);
                if (!graphJGraphT.containsEdge(id1, id2)) {
                    graphJGraphT.addEdge(id1, id2);
                }
            }
        }

        //calling function for finding the maximum playlist
        findingMaximumSetOfPlaylists();
    }

    private void creatingMap() {
        for (Integer i : idsList) {
            ArrayList<Integer> connection = new ArrayList<>();
            for (Integer j : idsList) {
                if (graphJGraphT.containsEdge(i, j)) {
                    connection.add(j);
                }
            }
            connectionPlaylist.put(i, connection);
            numberOfNeighbors.add(connectionPlaylist.get(i).size());
        }
    }

    private void findingMaximumSetOfPlaylists() {
        //local variables
        int length = numberAlbums();
        int counterLength = 0;
        ArrayList<String> finalSet = new ArrayList<>();
        boolean okay = false;

        //initialising the variable
        numberOfNeighbors = new ArrayList<>();

        //creating the map
        creatingMap();

        //my algorithm
        /*
        1. We always get album with the lowest number of neighbors
        2. We check other albums that have this album as neighbor -> we check them as length+1
            -> they will NOT be chosen in our final Set
        3. We keep doing this until all albums have been chosen or if the preference = length+1 (minimum of neighbors)
         */

        //creating the condition
        while (!okay) {
            int preference = Collections.min(numberOfNeighbors);
            if (preference == length + 1) {
                okay = true;
            } else {
                int location = numberOfNeighbors.indexOf(preference);
                numberOfNeighbors.set(location, length + 1);
                int id = idsList.get(location);
                finalSet.add(titles.get(location));
                counterLength++;
                for (Integer i : connectionPlaylist.keySet()) {
                    int index = idsList.indexOf(i);
                    if (numberOfNeighbors.get(index) != length + 1 && connectionPlaylist.get(i).contains(id)) {
                        numberOfNeighbors.set(index, length + 1);
                    }
                }
            }
            if (counterLength > length) {
                okay = true;
            }
        }
        /*for (String s : finalSet) {
            System.out.println(s);
        }*/
    }

    public void testSQL(){
        Connection con= Database.getConnection();
        try (Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT title " +
                             "FROM albums " +
                             "WHERE id_album IN("+
                     "SELECT a1.id_album " +
                             "FROM albums a1 CROSS JOIN albums a2 " +
                             "WHERE a1.id_album>a2.id_album AND " +
                             "( a1.release_year != a2.release_year AND a1.artist!=a2.artist)" +
                             " INTERSECT " +
                             "SELECT id_album " +
                             "FROM associative " +
                             "EXCEPT " +
                             "SELECT a1.id_album " +
                             "FROM associative a1 CROSS JOIN associative a2 " +
                             "WHERE a1.id_album>a2.id_album AND " +
                             "( a1.id_genre = a2.id_genre )" +
                             ")"
             )) {
            String id1;
            while (resultSet.next()) {
                id1 = resultSet.getString(1);
                System.out.println(id1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
