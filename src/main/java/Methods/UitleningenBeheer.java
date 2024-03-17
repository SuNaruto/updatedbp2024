package Methods; // Pas dit aan naar je package naam

import java.util.Date;
import java.util.Scanner;

import configuration.JPAConfiguration;
import entity.Boek;
import entity.Lid;
import entity.Uitlening;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.BoekService;
import service.LidService;
import service.UitleningService;

public class UitleningenBeheer {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = JPAConfiguration.getEntityManagerFactory();
    private static BoekService boekService = new BoekService(new BoekDAO(emf));
    private static LidService lidService = new LidService(new LidDAO(emf));
    private static UitleningService uitleningService = new UitleningService(new UitleningDAO(emf));


    public UitleningenBeheer(UitleningService uitleningService, BoekService boekService, LidService lidService, Scanner scanner) {
        this.uitleningService = uitleningService;
        this.boekService = boekService;
        this.lidService = lidService;
        this.scanner = scanner;
    }

    public void beheerUitleningen() {
        while (true) {
            System.out.println("\nUitleningen Beheer:");
            System.out.println("1. Boek uitlenen");
            System.out.println("2. Boek terugbrengen");
            System.out.println("3. Terug naar hoofdmenu");

            System.out.print("Kies een optie: ");
            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    leenBoekUit();
                    break;
                case 2:
                    brengBoekTerug();
                    break;
                case 3:
                    return; // Terug naar hoofdmenu
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }

    private static void leenBoekUit() {
        int lidId, boekId;
        try {
            System.out.print("Lid ID: ");
            lidId = Integer.parseInt(scanner.nextLine());
            System.out.print("Boek ID: ");
            boekId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer. Voer alstublieft geldige nummers in.");
            return;
        }

        Lid lid = lidService.getLid(lidId);
        Boek boek = boekService.getBoek(boekId);

        if (lid != null && boek != null && boekService.isBoekBeschikbaar(boekId) && boek.getAantal() > 0) {
            boek.setAantal(boek.getAantal() - 1);
            boekService.updateBoek(boek);

            Uitlening nieuweUitlening = new Uitlening(lid, boek, new Date());
            uitleningService.addUitlening(nieuweUitlening);
            System.out.println("Boek uitgeleend.");
        } else {
            System.out.println("Boek of lid niet gevonden, of boek is niet beschikbaar.");
        }
    }



    private static void brengBoekTerug() {
        int uitleningId;
        try {
            System.out.print("Uitlening ID: ");
            uitleningId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer. Voer een geldig uitlening ID in.");
            return;
        }

        Uitlening uitlening = uitleningService.getUitlening(uitleningId);
        if (uitlening != null) {
            uitlening.setTeruggebrachtOp(new Date());
            uitleningService.updateUitlening(uitlening);
            System.out.println("Boek teruggebracht.");

            // Verhoog de voorraad van het boek
            Boek boek = uitlening.getBoek();
            boek.setAantal(boek.getAantal() + 1);
            boekService.updateBoek(boek);
        } else {
            System.out.println("Uitlening niet gevonden.");
        }
    }


}
