package compulsory.repositories;

import compulsory.DatabaseUtils;
import compulsory.entities.Album;
import compulsory.entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AlbumRepository extends DataRepository<Album, Long> {
    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;
    public Class<Album> getEntityClass() {
        return Album.class;
    }

    public AlbumRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();

    }

    public List<Album> findByTitle(String title) {
        return getEntityManager()
                .createNamedQuery("Album.findByName")
                .setParameter(1, title)
                .getResultList();
    }

    public List<Album> findById(int id) {
        return getEntityManager().
                createNamedQuery("Album.findById")
                .setParameter(1, id)
                .getResultList();
    }

    public void create(Album album) {
        save(album);
    }
}
