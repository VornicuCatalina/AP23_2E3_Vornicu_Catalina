package compulsory.repositories;


import compulsory.entities.Genre;
import compulsory.factories.EntitiesClasses;

import java.util.List;

public class GenreRepository extends DataRepository<Genre, Long> implements EntitiesClasses {
    //private EntityManager em = DatabaseUtils.getInstance().getEntityManager();
    //private EntityTransaction entityTransaction;
    Genre genre;

    public Class<Genre> getEntityClass() {
        return Genre.class;
    }

    public GenreRepository() {
        //entityTransaction=em.getTransaction();
        //entityTransaction.begin();
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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

    @Override
    public void createEn() {
        save(genre);
    }
}