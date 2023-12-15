package antoniogiovanni.marchese.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("libro")
public class Libro extends Leggibile{

    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
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
