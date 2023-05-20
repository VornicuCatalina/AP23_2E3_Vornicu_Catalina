package compulsory.repositories;

import compulsory.entities.Artist;

import compulsory.factories.EntitiesClasses;

import java.util.List;

public class ArtistRepository extends DataRepository<Artist, Long> implements EntitiesClasses {
    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;
    Artist artist;

    public Class<Artist> getEntityClass() {
        return Artist.class;
    }

    public ArtistRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Artist> findByName(String name) {
        return getEntityManager()
                .createNamedQuery("Artist.findByArtist", Artist.class)
                .setParameter(1, name)
                .getResultList();
    }

    public List<Artist> findById(int id) {
        return getEntityManager()
                .createNamedQuery("Artist.findById", Artist.class)
                .setParameter(1, id)
                .getResultList();
    }

    @Override
    public void createEn() {
        save(artist);
    }
}
