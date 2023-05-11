package compulsory.repositories;

import compulsory.DatabaseUtils;
import compulsory.entities.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ArtistRepository extends DataRepository<Artist, Long> {
    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;
    public Class<Artist> getEntityClass() {
        return Artist.class;
    }

    public ArtistRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();
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

    public void create(Artist artist) {
        save(artist);
    }
}
