package compulsory;

import compulsory.entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Testing {
    public void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        em.persist(artist);

        Artist a = (Artist) em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        System.out.println(a.getName());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
