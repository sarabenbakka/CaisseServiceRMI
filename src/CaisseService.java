import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface CaisseService extends Remote {
    void ajouterCommande(String serveur, Map<String, Integer> plats) throws RemoteException;
    double calculerFacture(String serveur) throws RemoteException;
    Map<String, Map<String, Integer>> getCommandes() throws RemoteException;
}
