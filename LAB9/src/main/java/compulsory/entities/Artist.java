package compulsory.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e from Artist e where e.name = ?1"),
        @NamedQuery(name = "Artist.findById",
                query = "select e from Artist e where e.id_artist = ?1"),
})

public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "MyApplicationPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        em.persist(artist);

        Artist a = (Artist) em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
