import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

public class CaisseClient {
    CaisseService caisse;
    private String nomServeur;

    public CaisseClient(String nomServeur) {
        this.nomServeur = nomServeur;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            caisse = (CaisseService) registry.lookup("CaisseService");
        } catch (Exception e) {
            System.err.println("Erreur client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void envoyerCommande(Map<String, Integer> plats) {
        try {
            caisse.ajouterCommande(nomServeur, plats);
            System.out.println("Commande envoyée avec succès pour " + nomServeur);
        } catch (RemoteException e) {
            System.err.println("Erreur d'envoi : " + e.getMessage());
        }
    }
}