package compulsory.repositories;

import compulsory.DatabaseUtils;
import compulsory.entities.Artist;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private EntityManager em = DatabaseUtils.getInstance().getEntityManager();

    public List<Artist> findByName(String name) {
        return em.createNamedQuery("Artist.findByArtist")
                .setParameter("name", name)
                .getResultList();
    }

    public List<Artist> findById(int id) {
        return em.createNamedQuery("Artist.findById")
                .setParameter("id_artist", id)
                .getResultList();
    }

    public void create(String name) {
    }
}
