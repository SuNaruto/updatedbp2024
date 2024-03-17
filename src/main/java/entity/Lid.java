package entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;


@Entity
@Table(name = "leden")

public class Lid {

    public Lid() {
        // Standaard constructor
    }

    public Lid(String naam, String adres, String telefoonnummer) {
        this.naam = naam;
        this.adres = adres;
        this.telefoonnummer = telefoonnummer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid_id;

    @Column(name = "naam")
    private String naam;

    @Column(name = "adres")
    private String adres;

    @Column(name = "telefoonnummer")
    private String telefoonnummer;

    @OneToMany(mappedBy = "lid", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("lid")
    @LazyCollection(LazyCollectionOption.FALSE)
        private List<Uitlening> uitleningen;
/*    @OneToMany(*/
/*            cascade = CascadeType.ALL,*/
/*            orphanRemoval = true*/
/*    )*/
/*    @JoinColumn(name = "lid_id")*/
/*    private List<Uitlening> uitleningen;*/

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "uitleningen",
//            joinColumns = {@JoinColumn(name = "lid_id")},
//            inverseJoinColumns = {@JoinColumn(name = "boek_id")}
//    )
//    private List<Boek> boeken;

    // Stelt een one-to-many relatie in met Uitlening entiteiten, met 'lid' als de map-kolom.
    // Ophalen is 'lui' (LAZY) en cascade is ingesteld voor alle operaties (ALL).

/*    @JsonManagedReference(value = "uitleenLid")
    @OneToMany(mappedBy = "lid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Uitlening> uitleningen;*/
//
//    @Override
//    public String toString() {
//        return "Lid{" +
//                "lid_id=" + lid_id +
//                ", naam='" + naam + '\'' +
//                ", adres='" + adres + '\'' +
//                ", telefoonnummer='" + telefoonnummer + '\'' +
//                '}';
//    }

    public int getId() {
        return lid_id;
    }

    public void setId(int id) {
        this.lid_id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public List<Uitlening> getUitleningen() {
        return uitleningen;
    }

    public void setUitleningen(List<Uitlening> uitleningen) {
        this.uitleningen = uitleningen;
    }

    public int getLid_id() {
        return lid_id;
    }
    //    public List<Boek> getBoeken() {
//        return boeken;
//    }
//
//    public void setBoeken(List<Boek> boeken) {
//        this.boeken = boeken;
//    }

}
