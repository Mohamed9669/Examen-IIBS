package service;

import entity.Approvisionnement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApprovisionnementService {
    private List<Approvisionnement> approvisionnements;

    public ApprovisionnementService() {
        approvisionnements = new ArrayList<>();
    }

    public void enregistrerApprovisionnement(Approvisionnement appro) {
        approvisionnements.add(appro);
    }

    public List<Approvisionnement> listerApprovisionnements() {
        return approvisionnements;
    }

    public List<Approvisionnement> filtrerApprovisionnements(LocalDate debut, LocalDate fin) {
        return approvisionnements.stream()
            .filter(a -> !a.getDate().isBefore(debut) && !a.getDate().isAfter(fin))
            .collect(Collectors.toList());
    }
}