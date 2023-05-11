package compulsory.repositories;

import compulsory.DatabaseUtils;
import compulsory.entities.Artist;
import compulsory.entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class GenreRepository extends DataRepository<Genre, Long> {
    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;

    public Class<Genre> getEntityClass() {
        return Genre.class;
    }

    public GenreRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();
    }

    public List<Genre> findByName(String name) {
        return getEntityManager()
                .createNamedQuery("Genre.findByArtist")
                .setParameter(1, name)
                .getResultList();
    }

    public List<Genre> findById(int id) {
        return getEntityManager()
                .createNamedQuery("Genre.findById")
                .setParameter(1, id)
                .getResultList();
    }

    public void create(Genre genre) {
        save(genre);
    }
}