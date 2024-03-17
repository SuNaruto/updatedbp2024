package Methods; // Pas dit aan naar je package naam

import java.util.List;
import java.util.Scanner;


import entity.Categorie;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.BoekService;
import service.LidService;
import service.UitleningService;

public class CategorieenBeheer {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = configuration.JPAConfiguration.getEntityManagerFactory();
    private static BoekService boekService = new BoekService(new BoekDAO(emf));
    private static LidService lidService = new LidService(new LidDAO(emf));
    private static UitleningService uitleningService = new UitleningService(new UitleningDAO(emf));
    private static CategorieDAO categorieDAO = new CategorieDAO(emf);
    private static BoekDetailsDAO boekDetailsDAO = new BoekDetailsDAO(emf);
    public CategorieenBeheer(CategorieDAO categorieDAO, Scanner scanner) {
        this.categorieDAO = categorieDAO;
        this.scanner = scanner;
    }

    public void beheerCategorieen() {
        while (true) {
            System.out.println("\nCategorie Beheer:");
            System.out.println("1. Categorie toevoegen");
            System.out.println("2. Categorieën weergeven");
            System.out.println("3. Categorie bijwerken");
            System.out.println("4. Categorie verwijderen");
            System.out.println("5. Zoek Categorie");
            System.out.println("6. Terug naar hoofdmenu");

            System.out.print("Kies een optie: ");
            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    voegCategorieToe(categorieDAO);
                    break;
                case 2:
                    toonCategorieen(categorieDAO);
                    break;
                case 3:
                    updateCategorie(categorieDAO);
                    break;
                case 4:
                    verwijderCategorie(categorieDAO);
                    break;
                case 5:
                    zoekCategorie();
                    break;
                case 6:
                    return; // Terug naar hoofdmenu
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }


    private static void voegCategorieToe(CategorieDAO categorieDAO) {
        try {
            System.out.print("Naam van de categorie: ");
            String naam = scanner.nextLine();
            Categorie categorie = new Categorie(naam);
            categorieDAO.saveCategorie(categorie);
            System.out.println("Categorie toegevoegd.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

    private static void toonCategorieen(CategorieDAO categorieDAO) {
        List<Categorie> categorieen = categorieDAO.getAllCategorieen();
        for (Categorie c : categorieen) {
            System.out.println("ID: " + c.getCategorie_id() + ", Naam: " + c.getNaam());
        }
    }

    private static void updateCategorie(CategorieDAO categorieDAO) {
        try {
            System.out.print("Categorie ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nieuwe naam voor categorie: ");
            String naam = scanner.nextLine();

            Categorie categorie = new Categorie(naam);
            categorie.setCategorie_id(id);
            categorieDAO.updateCategorie(categorie);
            System.out.println("Categorie bijgewerkt.");
        } catch (NumberFormatException e) {
            System.out.println("Voer alstublieft een geldig nummer in.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

    private static void verwijderCategorie(CategorieDAO categorieDAO) {
        try {
            System.out.print("Categorie ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            categorieDAO.deleteCategorie(id);
            System.out.println("Categorie verwijderd.");
        } catch (NumberFormatException e) {
            System.out.println("Voer alstublieft een geldig nummer in.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }
    }

    private static void zoekCategorie() {
        try {
            System.out.print("Voer Categorie ID in: ");
            int id = Integer.parseInt(scanner.nextLine());
            Categorie categorie = categorieDAO.getCategorie(id);
            if (categorie != null) {
                System.out.println("Categorie gevonden: ID = " + categorie.getCategorie_id() + ", Naam = " + categorie.getNaam());
            } else {
                System.out.println("Geen categorie gevonden met ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Voer alstublieft een geldig nummer in.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Er is een fout opgetreden: " + e.getMessage());
        }

    }
}

