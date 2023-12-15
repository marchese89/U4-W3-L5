package antoniogiovanni.marchese;

import antoniogiovanni.marchese.dao.LeggibileDAO;
import antoniogiovanni.marchese.dao.PrestitoDAO;
import antoniogiovanni.marchese.dao.UtenteDAO;
import antoniogiovanni.marchese.entities.Libro;
import antoniogiovanni.marchese.entities.Prestito;
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
        PrestitoDAO pd = new PrestitoDAO(em);
        Utente utente1 = new Utente("NomeUtente","cognomeUtente",LocalDate.now().minusYears(20),232);
        //creiamo un utente
        //ud.save(utente1);
        Libro libro = new Libro("aaa123","TitoloLibro",1949,200,"AutoreLibro","Fantasy");
        //****************************************** AGGIUNTA AL CATALOGO ****************************************
        //ld.save(libro);
        //********************************************** RIMOZIONE PER CODICE ISBN *******************************
        //ld.findByISBNAndDelete("aaa123");
        System.out.println("***************************** RICERCA PER CODICE ISBN *****************************");
        System.out.println(ld.findByISBN("aaa123"));
        System.out.println("***************************** RICERCA PER ANNO PUBBLICAZIONE *****************************");
        ld.findByAnnoPubblicazione(1949).forEach(System.out::println);
        System.out.println("***************************** RICERCA PER AUTORE *****************************");
        ld.findByAutore("AutoreLibro").forEach(System.out::println);
        System.out.println("***************************** RICERCA PER TITOLO O PARTE DI ESSO *****************************");
        ld.findByTitoloOparte("toloLib").forEach(System.out::println);

        //creazione prestito
        Prestito prestito = new Prestito(ud.findById(6),ld.findById(5),LocalDate.now());
        //pd.save(prestito);
        System.out.println("***************************** RICERCA LEGGIBILI ATTUALMENTE IN PRESTITO DA N.TESSERA *****************************");
        pd.getPrestatiByTessera(232).forEach(System.out::println);
        System.out.println("***************************** RICERCA PRESTITI SCADUTI NON RESTITUITI *****************************");
        pd.getScadutiNonRestituiti().forEach(System.out::println);
    }
}
