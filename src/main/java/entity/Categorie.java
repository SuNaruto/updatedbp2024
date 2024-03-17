package entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorieen")
public class Categorie {

    public Categorie() {
        // Standaard constructor
    }

    public Categorie(String naam) {
        this.naam = naam;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categorie_id;

    @Column(name = "naam")
    private String naam;


    // Getters en setters
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }
}