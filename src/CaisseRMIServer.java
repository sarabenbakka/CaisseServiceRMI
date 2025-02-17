import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CaisseRMIServer {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            CaisseServerImpl server = new CaisseServerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CaisseService", server);
            System.out.println("Serveur de caisse démarré");
        } catch (Exception e) {
            System.err.println("Erreur serveur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
