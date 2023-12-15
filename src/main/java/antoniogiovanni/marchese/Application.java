package antoniogiovanni.marchese;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // Entity Manager è responsabile della gestione delle interazioni col DB
       
    }
}
