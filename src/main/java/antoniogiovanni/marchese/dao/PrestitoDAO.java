package antoniogiovanni.marchese.dao;

import antoniogiovanni.marchese.entities.Leggibile;
import antoniogiovanni.marchese.entities.Prestito;
import antoniogiovanni.marchese.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito di" + prestito.getElementoPrestato().getTitolo()+ " aggiunto correttamente!");
    }

    public Prestito findById(long id) {
        return em.find(Prestito.class,id);
    }


    public void findByIdAndDelete(long id) {
        Prestito found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Prestito di " + found.getElementoPrestato().getTitolo() + " eliminato correttamente!");
        } else {
            System.out.println("Prestito con id " + id + " non trovato");
        }

    }

    public List<Leggibile> getPrestatiByTessera(long numeroTessera){
        TypedQuery<Leggibile> findByTessera = em.createNamedQuery("elementiAttualmenteInPrestitoPerTesseraUtente",Leggibile.class);
        findByTessera.setParameter("numTessera",numeroTessera);
        return findByTessera.getResultList();
    }

    public List<Prestito> getScadutiNonRestituiti(){
        TypedQuery<Prestito> findScadutiNonRestituiti = em.createNamedQuery("prestitiScadutiEnonRestituiti",Prestito.class);
        return findScadutiNonRestituiti.getResultList();
    }
}
