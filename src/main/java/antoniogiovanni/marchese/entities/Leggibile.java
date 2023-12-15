package antoniogiovanni.marchese.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_leggibile")
public abstract class Leggibile {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "titolo")
    private String Titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    public Leggibile() {
    }

    public Leggibile(String titolo, int annoPubblicazione, int numeroPagine) {
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", Titolo='" + Titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine;
    }
}
