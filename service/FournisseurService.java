package service;

import entity.Fournisseur;
import java.util.ArrayList;
import java.util.List;

public class FournisseurService {
    private List<Fournisseur> fournisseurs;

    public FournisseurService() {
        fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur(1, "Papeterie Sn"));
        fournisseurs.add(new Fournisseur(2, "BureauPro"));
        fournisseurs.add(new Fournisseur(3, "OfficePlus"));
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }
} 