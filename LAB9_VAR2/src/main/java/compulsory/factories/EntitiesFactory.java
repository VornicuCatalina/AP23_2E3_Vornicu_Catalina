package compulsory.factories;

import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;
import compulsory.repositories.GenreRepository;

public class EntitiesFactory extends AbstractFactory{
    @Override
    public EntitiesClasses createEn(String type) {
        if(type.equalsIgnoreCase("Artist")){
            return new ArtistRepository();
        }
        else if(type.equalsIgnoreCase("Album")){
            return new AlbumRepository();
        }
        else if(type.equalsIgnoreCase("Genre")){
            return new GenreRepository();
        }
        return null;
    }

    @Override
    public DAOClasses create(String type) {
        return null;
    }
}
