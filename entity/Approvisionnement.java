package entity;

import java.time.LocalDate;
import java.util.List;

public class Approvisionnement {
    private int id;
    private LocalDate date;
    private Fournisseur fournisseur;
    private List<LigneApprovisionnement> lignes;
    private String statut;

    public Approvisionnement(int id, LocalDate date, Fournisseur fournisseur, List<LigneApprovisionnement> lignes, String statut) {
        this.id = id;
        this.date = date;
        this.fournisseur = fournisseur;
        this.lignes = lignes;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneApprovisionnement> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneApprovisionnement> lignes) {
        this.lignes = lignes;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double calculerMontantTotal() {
        return lignes.stream().mapToDouble(LigneApprovisionnement::getMontant).sum();
    }
} 