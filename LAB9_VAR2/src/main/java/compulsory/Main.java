package compulsory;

import com.github.javafaker.Faker;
import compulsory.entities.Album;
import compulsory.entities.Artist;
import compulsory.factories.AbstractFactory;
import compulsory.factories.FactoryCreator;
import compulsory.jdbcRepositories.ArtistDAO;
import compulsory.repositories.AlbumRepository;
import compulsory.repositories.ArtistRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //the start of the execution call - homework
        //long start = System.nanoTime();

        //creating the repositories
        /*ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        Artist artist=new Artist("Checker");
        artistRepository.setArtist(artist);
        artistRepository.createEn();*/

        //creating those fake artists - homework
        //Faker faker = new Faker();

        //creating 1k artists and 1k albums - homework
        //for genres : 3 options : rock , pop , hip hop
        /*String[] genres=new String[3];
        genres[0]="rock";
        genres[1]="pop";
        genres[2]="hip hop";


        int counter=0;
        int chooseGenre;
        int chooseYear;
        while(counter<1000){
            artistRepository.save(new Artist(faker.name().fullName()));
            chooseGenre=(int)(Math.random()*3);
            chooseYear=(int)(Math.random()*99)+1900;
            albumRepository.save(new Album(faker.name().title(),faker.name().fullName(),genres[chooseGenre],chooseYear ));
            counter++;
        }
        */

        //now checking my JPQL -homework
        //System.out.println(albumRepository.findByTitle("Chief Accountability Executive"));

        //the finish time - homework
        //long finish = System.nanoTime();
        //System.out.println("The execution time is " + (finish - start));

        //for bonus
        /*AbstractFactory DAOFactory = FactoryCreator.getFactory("DAO");
        AbstractFactory entityFactory = FactoryCreator.getFactory("Entity");
        ArtistRepository artistRepository = (ArtistRepository) entityFactory.createEn("Artist");
        Artist a = new Artist("George");
        artistRepository.setArtist(a);
        artistRepository.createEn();

        ArtistDAO artistDAO = (ArtistDAO) DAOFactory.create("Artist");
        artistDAO.setName("George2");
        artistDAO.create();*/

        ExistenceAlgorithm existenceAlgorithm = new ExistenceAlgorithm(2, 3);
        System.out.println(existenceAlgorithm.returnAlbum());


    }
}