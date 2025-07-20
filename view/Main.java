package view;
import entity.*;
import service.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleService articleService = new ArticleService();
        FournisseurService fournisseurService = new FournisseurService();
        ApprovisionnementService approService = new ApprovisionnementService();

        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Enregistrer un approvisionnement");
            System.out.println("2. Lister les approvisionnements");
            System.out.println("3. Filtrer les approvisionnements par période");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    
                    System.out.println("--- Création d'un approvisionnement ---");
                    
                    System.out.println("Choisissez un fournisseur :");
                    List<Fournisseur> fournisseurs = fournisseurService.getFournisseurs();
                    for (int i = 0; i < fournisseurs.size(); i++) {
                        System.out.println((i+1) + ". " + fournisseurs.get(i).getNom());
                    }
                    int choixF = scanner.nextInt();
                    Fournisseur fournisseur = fournisseurs.get(choixF-1);

                    
                    List<LigneApprovisionnement> lignes = new ArrayList<>();
                    String continuer;
                    do {
                        System.out.println("Choisissez un article :");
                        List<Article> articles = articleService.getArticles();
                        for (int i = 0; i < articles.size(); i++) {
                            System.out.println((i+1) + ". " + articles.get(i).getNom());
                        }
                        int choixA = scanner.nextInt();
                        Article article = articles.get(choixA-1);
                        System.out.print("Quantité : ");
                        int quantite = scanner.nextInt();
                        System.out.print("Prix unitaire : ");
                        double prix = scanner.nextDouble();
                        lignes.add(new LigneApprovisionnement(article, quantite, prix));
                        System.out.print("Ajouter un autre article ? (o/n) : ");
                        continuer = scanner.next();
                    } while (continuer.equalsIgnoreCase("o"));

                    if (lignes.isEmpty()) {
                        System.out.println("Erreur : il faut au moins un article.");
                        break;
                    }

                    Approvisionnement appro = new Approvisionnement(
                        new Random().nextInt(10000),
                        LocalDate.now(),
                        fournisseur,
                        lignes,
                        "ENREGISTRE"
                    );
                    approService.enregistrerApprovisionnement(appro);
                    System.out.println("Approvisionnement enregistré avec succès !");
                    System.out.println("Montant total : " + appro.calculerMontantTotal() + " fcfa");
                    break;
                case 2:
                    System.out.println("\n--- Liste des approvisionnements ---");
                    for (Approvisionnement a : approService.listerApprovisionnements()) {
                        System.out.println("ID: " + a.getId() + ", Date: " + a.getDate() + ", Fournisseur: " + a.getFournisseur().getNom() + ", Montant: " + a.calculerMontantTotal() + " fcfa");
                    }
                    break;
                case 3:
                    System.out.print("Date début (AAAA-MM-JJ) : ");
                    String debutStr = scanner.nextLine();
                    System.out.print("Date fin (AAAA-MM-JJ) : ");
                    String finStr = scanner.nextLine();
                    LocalDate debut = LocalDate.parse(debutStr);
                    LocalDate fin = LocalDate.parse(finStr);
                    List<Approvisionnement> resultats = approService.filtrerApprovisionnements(debut, fin);
                    System.out.println("--- Approvisionnements filtrés ---");
                    for (Approvisionnement a : resultats) {
                        System.out.println("ID: " + a.getId() + ", Date: " + a.getDate() + ", Fournisseur: " + a.getFournisseur().getNom() + ", Montant: " + a.calculerMontantTotal() + " fcfa");
                    }
                    break;
                case 0:
                    System.out.println( "!");
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
} 