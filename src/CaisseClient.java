import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

public class CaisseClient {
    CaisseService caisse;
    private String nomServeur;

    public CaisseClient(String nomServeur) {
        this.nomServeur = nomServeur; // Initialisation de la variable nomServeur
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            // Recherche du service RMI
            caisse = (CaisseService) registry.lookup("CaisseService");
        } catch (Exception e) {
            System.err.println("Erreur client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Méthode pour envoyer une commande
    public void envoyerCommande(Map<String, Integer> plats) {
        try {
            // Appel de la méthode distante pour ajouter la commande
            caisse.ajouterCommande(nomServeur, plats);
            System.out.println("Commande envoyée avec succès pour " + nomServeur);
        } catch (RemoteException e) {
            System.err.println("Erreur d'envoi : " + e.getMessage());
        }
    }
}