package Methods; // Pas dit aan naar je package naam

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;


import dto.BoekDTO;
import dto.UitleningDTO;
import entity.Boek;
import entity.Uitlening;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import service.BoekService;
import service.LidService;
import service.UitleningService;

public class RapportenBeheer {
    static Scanner scanner = new Scanner(System.in);
    private static EntityManagerFactory emf = configuration.JPAConfiguration.getEntityManagerFactory();
    private static BoekService boekService = new BoekService(new BoekDAO(emf));
    private static LidService lidService = new LidService(new LidDAO(emf));
    private static UitleningService uitleningService = new UitleningService(new UitleningDAO(emf));
    private static CategorieDAO categorieDAO = new CategorieDAO(emf);
    private static BoekDetailsDAO boekDetailsDAO = new BoekDetailsDAO(emf);

    public RapportenBeheer(UitleningService uitleningService, BoekService boekService, Scanner scanner) {
        this.uitleningService = uitleningService;
        this.boekService = boekService;
        this.scanner = scanner;
    }

    public void genereerRapporten() {
        while (true) {
            System.out.println("\nRapporten Genereren:");
            System.out.println("1. Rapport van uitgeleende boeken");
            System.out.println("2. Rapport van late retouren");
            System.out.println("3. Rapport van BoekenRapport");
            System.out.println("4. Terug naar hoofdmenu");

            System.out.print("Kies een optie: ");
            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {
                case 1:
                    genereerUitgeleendeBoekenRapport();
                    break;
                case 2:
                    genereerLateRetourenRapport();
                    break;
                case 3:
                    genereerBoekenRapport();
                    break;
                case 4:
                    return; // Terug naar hoofdmenu
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }

    private static void genereerUitgeleendeBoekenRapport() {
        List<UitleningDTO> uitleningen = uitleningService.getAllUitleningen();
        for (UitleningDTO u : uitleningen) {
            if (u.getTeruggebrachtOp() == null) {
                System.out.println("Uitlening ID: " + u.getUitlening_id() +
                        ", Boek ID: " + u.getBoek().getBoek_id() +
                        ", Uitgeleend op: " + u.getUitgeleendOp());
            }
        }
        // Terug naar hoofdmenu
        return;
    }



    private static void genereerLateRetourenRapport() {
        List<UitleningDTO> uitleningen = uitleningService.getAllUitleningen();
        for (UitleningDTO u : uitleningen) {
            if (u.getTeruggebrachtOp() != null) {
                long dagenTeLaat = ChronoUnit.DAYS.between(u.getUitgeleendOp().toInstant(), u.getTeruggebrachtOp().toInstant()) - 30;
                if (dagenTeLaat > 0) {
                    System.out.println("Late uitlening - Uitlening ID: " + u.getUitlening_id() +
                            ", Boek ID: " + u.getBoek().getAantal() +
                            ", Uitgeleend op: " + u.getUitgeleendOp() +
                            ", Teruggebracht op: " + u.getTeruggebrachtOp() +
                            ", Dagen te laat: " + dagenTeLaat +
                            ", Boete: " + (dagenTeLaat * 5) + " SRD");
                }
            }
        }
// Terug naar hoofdmenu
        return;
    }

    private static void genereerBoekenRapport() {
        List<BoekDTO> alleBoeken = boekService.getAllBoeken();
        if (alleBoeken.isEmpty()) {
            System.out.println("Er zijn momenteel geen boeken in de bibliotheek.");
        } else {
            System.out.println("\nAlle Boeken in de Bibliotheek:");
            for (BoekDTO boek : alleBoeken) {
                System.out.println("ID: " + boek.getBoek_id() + ", Titel: " + boek.getTitel() +
                        ", Auteur: " + boek.getAuteur()  +
                        ", Aantal: " + boek.getAantal());
                // Hier kan je meer informatie toevoegen indien nodig
            }
        }
    }
}
