package Methods; // Pas dit aan naar je package naam


import entity.Lid;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.LidService;

import java.util.Scanner;

public class LedenBeheer {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = configuration.JPAConfiguration.getEntityManagerFactory();
    private static LidService lidService = new LidService(new LidDAO(emf));


    public LedenBeheer(LidService lidService, Scanner scanner) {
        this.lidService = lidService;
        LedenBeheer.scanner = scanner;
    }

    public void beheerLeden() {
        while (true) {
            try {
                System.out.println("\nLeden Beheer:");
                System.out.println("1. Lid toevoegen");
                System.out.println("2. Lid bijwerken");
                System.out.println("3. Lid verwijderen");
                System.out.println("4. Lid zoeken");
                System.out.println("5. Terug naar hoofdmenu");

                System.out.print("Kies een optie: ");
                int keuze = Integer.parseInt(scanner.nextLine());

                switch (keuze) {
                    case 1:
                        voegLidToe();
                        break;
                    case 2:
                        updateLid();
                        break;
                    case 3:
                        verwijderLid();
                        break;
                    case 4:
                        zoekLid();
                        break;
                    case 5:
                        return; // Gaat terug naar het hoofdmenu
                    default:
                        System.out.println("Ongeldige keuze, probeer opnieuw.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Voer alstublieft een geldig nummer in.");
            } catch (Exception e) {
                System.out.println("Er is een fout opgetreden: " + e.getMessage());
            }
        }
    }


    private static void voegLidToe() {
        try {
            System.out.print("Naam: ");
            String naam = scanner.nextLine
                    (); // Gebruik nextLine() voor consistente input handling
            System.out.print("Adres: ");
            String adres = scanner.nextLine();
            System.out.print("Telefoonnummer: ");
            String telefoonnummer = scanner.nextLine();


            Lid nieuwLid = new Lid(naam, adres, telefoonnummer);
            lidService.addLid(nieuwLid);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }


    private static void updateLid() {
        try {
            System.out.print("Lid ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nieuwe naam: ");
            String naam = scanner.nextLine();
            System.out.print("Nieuw adres: ");
            String adres = scanner.nextLine();
            System.out.print("Nieuw telefoonnummer: ");
            String telefoonnummer = scanner.nextLine();

            Lid lid = lidService.getLid(id);
            if (lid != null) {
                lid.setNaam(naam);
                lid.setAdres(adres);
                lid.setTelefoonnummer(telefoonnummer);
                lidService.updateLid(lid);
                System.out.println("Lidgegevens bijgewerkt.");
            } else {
                System.out.println("Lid niet gevonden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

    private static void verwijderLid() {
        try {
            System.out.print("Lid ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Lid lid = lidService.getLid(id);
            if (lid != null) {
                lidService.deleteLid(id);
                System.out.println("Lid verwijderd.");
            } else {
                System.out.println("Lid niet gevonden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

    private static void zoekLid() {
        try {
            System.out.print("Lid ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            Lid lid = lidService.getLid(id);
            if (lid != null) {
                System.out.println("Lid gevonden: " + lid.getNaam() + ", " + lid.getAdres() + ", " + lid.getTelefoonnummer());
            } else {
                System.out.println("Lid niet gevonden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

}
