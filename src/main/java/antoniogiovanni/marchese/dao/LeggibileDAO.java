package antoniogiovanni.marchese.dao;

import antoniogiovanni.marchese.entities.Leggibile;
import antoniogiovanni.marchese.entities.Libro;
import antoniogiovanni.marchese.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LeggibileDAO {
    private final EntityManager em;

    public LeggibileDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Leggibile leggibile) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(leggibile);
        transaction.commit();
        System.out.println("Leggibile " + leggibile.getTitolo() + " aggiunto correttamente!");
    }

    public Leggibile findById(long id) {
        return em.find(Leggibile.class,id);
    }


    public void findByIdAndDelete(long id) {
        Leggibile found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Leggibile " + found.getTitolo() + " eliminato correttamente!");
        } else {
            System.out.println("Leggibile con id " + id + " non trovato");
        }

    }

    public void findByISBNAndDelete(String isbn) {
        TypedQuery<Leggibile> findByISBN = em.createQuery("SELECT l FROM Leggibile l WHERE l.codiceISBN = :isbn",Leggibile.class);
        findByISBN.setParameter("isbn",isbn);
        Leggibile found = findByISBN.getSingleResult();
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Leggibile " + found.getTitolo() + " eliminato correttamente!");
        } else {
            System.out.println("Leggibile con isbn " + isbn + " non trovato");
        }

    }

    public Leggibile findByISBN(String isbn) {
        TypedQuery<Leggibile> findByISBN = em.createNamedQuery("ricercaLeggibilePerISBN",Leggibile.class);
        findByISBN.setParameter("codiceISBN",isbn);
        return findByISBN.getSingleResult();
    }

    public List<Leggibile> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Leggibile> findByISBN = em.createNamedQuery("ricercaLeggibilePerAnnoPubblicazione",Leggibile.class);
        findByISBN.setParameter("annoPubblicazione",annoPubblicazione);
        return findByISBN.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> findByISBN = em.createNamedQuery("ricercaLibroPerAutore",Libro.class);
        findByISBN.setParameter("autore",autore);
        return findByISBN.getResultList();
    }

    public List<Leggibile> findByTitoloOparte(String titolo) {
        TypedQuery<Leggibile> findByISBN = em.createNamedQuery("ricercaLeggibilePerTitoloOparte",Leggibile.class);
        findByISBN.setParameter("titolo",titolo);
        return findByISBN.getResultList();
    }


}
