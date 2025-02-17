public class Commande {
    private String plat;
    private int quantite;
    private double prixTotal;

    public Commande(String plat, int quantite, double prixTotal) {
        this.plat = plat;
        this.quantite = quantite;
        this.prixTotal = prixTotal;
    }

    // Getters
    public String getPlat() { return plat; }
    public int getQuantite() { return quantite; }
    public double getPrixTotal() { return prixTotal; }
}