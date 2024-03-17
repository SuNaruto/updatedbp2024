package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "boeken")

public class Boek {

    public Boek() {
        // Standaard constructor
    }

    public Boek(String titel, String auteur, int aantal) {
        this.titel = titel;
        this.auteur = auteur;
        this.aantal = aantal;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boek_id;

    @Column(name = "Titel")
    private String titel;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "aantal")
    private int aantal;

    @OneToMany(mappedBy = "boek", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("boek")
    private List<Uitlening> uitleningen;


    // Defineert een many-to-many relatie tussen Boek en Categorie met een join tabel 'boek_categorie'.
    // Ophalen van categorieën gebeurt 'lui' (LAZY) en de merge cascade optie is ingesteld.

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "boek_categorie", joinColumns = @JoinColumn(name = "boek_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Set<Categorie> categorien;

    public int getBoek_id() {
        return boek_id;
    }

    public void setBoek_id(int boek_id) {
        this.boek_id = boek_id;
    }

    public Set<Categorie> getCategorien() {
        return categorien;
    }

    public void setCategorien(Set<Categorie> categorien) {
        this.categorien = categorien;
    }


    public int getId() { return boek_id; }
    public void setId(int id) { this.boek_id = id; }
    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    //    public Set<Categorie> getCategorieen() { return categorieen; }
//    public void setCategorieen(Set<Categorie> categorieen) { this.categorieen = categorieen; }
    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
    public List<Uitlening> getUitleningen() {
        return uitleningen;
    }

    public void setUitleningen(List<Uitlening> uitleningen) {
        this.uitleningen = uitleningen;
    }
}