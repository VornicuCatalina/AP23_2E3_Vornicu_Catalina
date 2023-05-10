package compulsory;

import compulsory.entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Artist a = (Artist) em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        entityTransaction.commit();
        em.close();
        emf.close();
    }
}