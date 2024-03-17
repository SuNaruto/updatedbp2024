package Methods; // Pas dit aan naar je package naam

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import configuration.JPAConfiguration;
import entity.Boek;
import entity.BoekDetails;
import entity.Categorie;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.BoekService;
import service.LidService;

public class BoekenBeheer {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = JPAConfiguration.getEntityManagerFactory();

    private static BoekService boekService = new BoekService(new BoekDAO(emf));
    private static LidService lidService = new LidService(new LidDAO(emf));
    private static CategorieDAO categorieDAO = new CategorieDAO(emf);
    private static BoekDetailsDAO boekDetailsDAO = new BoekDetailsDAO(emf);


    public BoekenBeheer(BoekService boekService, CategorieDAO categorieDAO, BoekDetailsDAO boekDetailsDAO, Scanner scanner) {
        this.boekService = boekService;
        this.categorieDAO = categorieDAO;
        this.boekDetailsDAO = boekDetailsDAO;
        this.scanner = scanner;
    }

    public void beheerBoeken() {
        while (true) {
            System.out.println("\nBoeken Beheer:");
            System.out.println("1. Boek toevoegen");
            System.out.println("2. Boek bijwerken");
            System.out.println("3. Boek verwijderen");
            System.out.println("4. Boek zoeken");
            System.out.println("5. Terug naar hoofdmenu");

            System.out.print("Kies een optie: ");
            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    voegBoekToe();
                    break;
                case 2:
                    updateBoek();
                    break;
                case 3:
                    verwijderBoek();
                    break;
                case 4:
                    zoekBoek();
                    break;
                case 5:
                    return; // Terug naar hoofdmenu
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }


    private static void voegBoekToe() {
        System.out.print("Titel: ");
        String titel = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();


        // Toon beschikbare categorieën
        List<Categorie> alleCategorieen = categorieDAO.getAllCategorieen();
        for (Categorie c : alleCategorieen) {
            System.out.println("Categorie ID: " + c.getCategorie_id() + ", Naam: " + c.getNaam());
        }

        // Laat de gebruiker categorieën kiezen
        System.out.print("Selecteer categorieën (IDs gescheiden door komma's): ");
        String[] gekozenCategorieIds = scanner.nextLine().split(",");
        Set<Categorie> geselecteerdeCategorieen = new HashSet<>();
        for (String idString : gekozenCategorieIds) {
            try {
                int id = Integer.parseInt(idString.trim());
                Categorie categorie = categorieDAO.getCategorie(id);
                if (categorie != null) {
                    geselecteerdeCategorieen.add(categorie);
                } else {
                    System.out.println("Categorie met ID " + id + " bestaat niet.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer voor categorie ID: " + idString);
            }
        }

        // Probeert het ingevoerde aantal exemplaren als een integer te lezen.
        // Bij ongeldige invoer wordt aantal ingesteld op 0 met een foutmelding.

        System.out.print("Aantal exemplaren: ");
        int aantal;
        try {
            aantal = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer voor aantal. Standaardwaarde 0 wordt gebruikt.");
            aantal = 0;
        }

        Boek nieuwBoek = new Boek(titel, auteur, aantal);
        nieuwBoek.setCategorien(geselecteerdeCategorieen);
        boekService.addBoek(nieuwBoek);

        System.out.print("Beschrijving: ");
        String beschrijving = scanner.nextLine();
        BoekDetails boekDetails = new BoekDetails(beschrijving, nieuwBoek);
        boekDetailsDAO.saveBoekDetails(boekDetails);

        System.out.println("Boek '" + titel + "' succesvol toegevoegd met details en categorieën.");
    }




    private static void updateBoek() {
        System.out.print("Boek ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        // Vraagt en leest nieuwe gegevens voor titel, auteur en aantal exemplaren.
        // Bij ongeldige invoer voor aantal, wordt standaardwaarde 0 gebruikt.

        System.out.print("Nieuwe titel: ");
        String titel = scanner.nextLine();
        System.out.print("Nieuwe auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Nieuw aantal exemplaren: ");
        int aantal;
        try {
            aantal = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer voor aantal. Standaardwaarde 0 wordt gebruikt.");
            aantal = 0;
        }

        System.out.print("Selecteer categorieën (IDs gescheiden door komma's): ");
        // Verwerkt gebruikersinvoer voor categorie-IDs,
        // scheidt ze en vult een set met overeenkomstige Categorie objecten.
        // Vangt ongeldige of niet-bestaande categorie-IDs op.

        String[] gekozenCategorieIds = scanner.nextLine().split(",");
        Set<Categorie> geselecteerdeCategorieen = new HashSet<>();
        for (String idString : gekozenCategorieIds) {
            try {
                int idCat = Integer.parseInt(idString.trim());
                Categorie categorie = categorieDAO.getCategorie(idCat);
                if (categorie != null) {
                    geselecteerdeCategorieen.add(categorie);
                } else {
                    System.out.println("Categorie met ID " + idCat + " bestaat niet.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer voor categorie ID: " + idString);
            }
        }


        Boek boek = boekService.getBoek(id);
        if (boek != null) {
            boek.setTitel(titel);
            boek.setAuteur(auteur);
            boek.setAantal(aantal);
            boek.setCategorien(geselecteerdeCategorieen);
            boekService.updateBoek(boek);
            System.out.println("Boekgegevens bijgewerkt.");
        } else {
            System.out.println("Boek niet gevonden.");
        }
    }



    private static void verwijderBoek() {
        System.out.print("Boek ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
            boekService.deleteBoek(id);
            System.out.println("Boek verwijderd.");
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer. Voer alstublieft een geldig boek ID in.");
        }
    }


    private static void zoekBoek() {
        System.out.print("Boek ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
            Boek boek = boekService.getBoek(id);
            if (boek != null) {
                BoekDetails boekDetails = boekDetailsDAO.getBoekDetails(boek.getId());
                System.out.println("Boek gevonden: " + boek.getTitel() + ", " + boek.getAuteur());
                if (boekDetails != null) {
                    System.out.println("Beschrijving: " + boekDetails.getBeschrijving());
                } else {
                    System.out.println("Geen details beschikbaar voor dit boek.");
                }
            } else {
                System.out.println("Boek niet gevonden.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer voor Boek ID.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }


}
