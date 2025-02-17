import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CaisseServerImpl extends UnicastRemoteObject implements CaisseService {
    private Map<String, Map<String, Integer>> commandes = new HashMap<>();
    private Map<String, Plat> menu = new HashMap<>();

    public CaisseServerImpl() throws RemoteException {
        // Initialisation du menu
        menu.put("Pizza", new Plat("Pizza", 12.0));
        menu.put("Pâtes", new Plat("Pâtes", 10.0));
        menu.put("Salade", new Plat("Salade", 8.0));
    }

    @Override
    public synchronized void ajouterCommande(String serveur, Map<String, Integer> plats) throws RemoteException {
        commandes.merge(serveur, plats, (oldVal, newVal) -> {
            newVal.forEach((plat, qte) -> oldVal.merge(plat, qte, Integer::sum));
            return oldVal;
        });
    }

    @Override
    public double calculerFacture(String serveur) {
        return commandes.getOrDefault(serveur, new HashMap<>()).entrySet().stream()
                .mapToDouble(e -> menu.get(e.getKey()).getPrix() * e.getValue())
                .sum();
    }

    @Override
    public Map<String, Map<String, Integer>> getCommandes() throws RemoteException {
        return null;
    }
}