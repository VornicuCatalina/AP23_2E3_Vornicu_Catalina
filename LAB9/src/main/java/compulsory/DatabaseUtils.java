package compulsory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseUtils {
    String PERSISTENCE_UNIT_NAME = "MyApplicationPU";
    private static DatabaseUtils instance;
    private final EntityManagerFactory entityManagerFactory;

    private DatabaseUtils() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
