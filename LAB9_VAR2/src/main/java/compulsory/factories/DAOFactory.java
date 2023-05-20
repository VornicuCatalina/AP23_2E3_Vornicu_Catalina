package compulsory.factories;

import compulsory.jdbcRepositories.AlbumDAO;
import compulsory.jdbcRepositories.ArtistDAO;
import compulsory.jdbcRepositories.GenreDAO;

public class DAOFactory extends AbstractFactory {
    @Override
    public DAOClasses create(String type) {
        if (type.equalsIgnoreCase("Artist")) {
            return new ArtistDAO();
        } else if (type.equalsIgnoreCase("Album")) {
            return new AlbumDAO();
        } else if (type.equalsIgnoreCase("Genre")) {
            return new GenreDAO();
        }
        return null;
    }

    public EntitiesClasses createEn(String type) {
        return null;
    }
}
