package entity;

public class LigneApprovisionnement {
    private Article article;
    private int quantite;
    private double prixUnitaire;
    private double montant;

    public LigneApprovisionnement(Article article, int quantite, double prixUnitaire) {
        this.article = article;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montant = quantite * prixUnitaire;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
        this.montant = this.quantite * this.prixUnitaire;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
        this.montant = this.quantite * this.prixUnitaire;
    }

    public double getMontant() {
        return montant;
    }
} 