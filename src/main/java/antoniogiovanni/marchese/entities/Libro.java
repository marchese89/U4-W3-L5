package antoniogiovanni.marchese.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("libro")
@NamedQuery(name = "ricercaLibroPerAutore",query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends Leggibile{

    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString()+
                " autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " ;
    }
}
