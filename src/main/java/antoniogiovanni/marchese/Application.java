package antoniogiovanni.marchese;

import antoniogiovanni.marchese.dao.LeggibileDAO;
import antoniogiovanni.marchese.dao.UtenteDAO;
import antoniogiovanni.marchese.entities.Libro;
import antoniogiovanni.marchese.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        UtenteDAO ud = new UtenteDAO(em);
        LeggibileDAO ld = new LeggibileDAO(em);
        Utente utente1 = new Utente("NomeUtente","cognomeUtente",LocalDate.now().minusYears(20),232);
        //ud.save(utente1);
        Libro libro = new Libro("aaa123","TitoloLibro",1949,200,"AutoreLibro","Fantasy");
        //ld.save(libro);
        ld.findByISBNAndDelete("aaa123");
    }
}
