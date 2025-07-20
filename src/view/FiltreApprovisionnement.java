package view;

import entity.Approvisionnement;
import service.ApprovisionnementService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FiltreApprovisionnement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApprovisionnementService approService = new ApprovisionnementService();
        // Ici, on suppose que des approvisionnements existent déjà dans le service
        System.out.print("Date début (AAAA-MM-JJ) : ");
        String debutStr = scanner.nextLine();
        System.out.print("Date fin (AAAA-MM-JJ) : ");
        String finStr = scanner.nextLine();
        LocalDate debut = LocalDate.parse(debutStr);
        LocalDate fin = LocalDate.parse(finStr);
        List<Approvisionnement> resultats = approService.filtrerApprovisionnements(debut, fin);
        System.out.println("--- Approvisionnements filtrés ---");
        for (Approvisionnement a : resultats) {
            System.out.println("ID: " + a.getId() + ", Date: " + a.getDate() + ", Fournisseur: " + a.getFournisseur().getNom() + ", Montant: " + a.calculerMontantTotal() + " €");
        }
    }
} 