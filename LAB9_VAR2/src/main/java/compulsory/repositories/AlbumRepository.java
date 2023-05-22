package compulsory.repositories;

import compulsory.entities.Album;
import compulsory.factories.EntitiesClasses;

import java.util.List;

public class AlbumRepository extends DataRepository<Album, Long> implements EntitiesClasses {
    Album album;

    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;
    public Class<Album> getEntityClass() {
        return Album.class;
    }

    public AlbumRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();


    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> findByTitle(String title) {
        return getEntityManager()
                .createNamedQuery("Album.findByName", Album.class)
                .setParameter(1, title)
                .getResultList();
    }

    public List<Album> findById(int id) {
        return getEntityManager().
                createNamedQuery("Album.findById", Album.class)
                .setParameter(1, id)
                .getResultList();
    }

    public List<Album> findByFirstLetter(String letter) {
        return getEntityManager()
                .createNamedQuery("Album.findByFirstLetter", Album.class)
                .setParameter(1, letter)
                .getResultList();
    }

    @Override
    public void createEn() {
        save(album);
    }
}
