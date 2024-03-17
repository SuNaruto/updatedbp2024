import java.util.Scanner;

import Methods.*;
import configuration.JPAConfiguration;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = JPAConfiguration.getEntityManagerFactory();
    private static BoekService boekService = new BoekService(new BoekDAO(emf));
    private static LidService lidService = new LidService(new LidDAO(emf));
    private static UitleningService uitleningService = new UitleningService(new UitleningDAO(emf));
    private static CategorieDAO categorieDAO = new CategorieDAO(emf);
    private static BoekDetailsDAO boekDetailsDAO = new BoekDetailsDAO(emf);
    static LedenBeheer ledenBeheer = new LedenBeheer(lidService, scanner);

    static BoekenBeheer boekenBeheer = new BoekenBeheer(boekService, categorieDAO, boekDetailsDAO, scanner);
    static UitleningenBeheer uitleningenBeheer = new UitleningenBeheer(uitleningService, boekService, lidService, scanner);
    static RapportenBeheer rapportenBeheer = new RapportenBeheer(uitleningService, boekService, scanner);
    static CategorieenBeheer categorieenBeheer = new CategorieenBeheer(categorieDAO, scanner);


    //Toont menu, verwerkt gebruikersinvoer voor verschillende beheertaken
    // (leden, boeken, uitleningen, rapporten, categorieën) en afsluiting van de applicatie.
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Welkom bij de Bibliotheek Beheer Applicatie");
                System.out.println("1. Leden beheren");
                System.out.println("2. Boeken beheren");
                System.out.println("3. Uitleningen beheren");
                System.out.println("4. Rapporten genereren");
                System.out.println("5. Categorieën beheren");
                System.out.println("6. Afsluiten");

                System.out.print("Kies een optie: ");
                int keuze = Integer.parseInt(scanner.nextLine());

                switch (keuze) {
                    case 1:
                        ledenBeheer.beheerLeden();
                        break;
                    case 2:
                        boekenBeheer.beheerBoeken();
                        break;
                    case 3:
                        uitleningenBeheer.beheerUitleningen();
                        break;
                    case 4:
                        rapportenBeheer.genereerRapporten();
                        break;
                    case 5:
                        categorieenBeheer.beheerCategorieen();
                        break;
                    case 6:
                        System.out.println("Applicatie afsluiten...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ongeldige keuze, probeer opnieuw.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Voer alstublieft een geldig nummer in.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Er is een fout opgetreden: " + e.getMessage());
            }
        }
    }
}













