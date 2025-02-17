import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CaisseGUI extends Application {
    private final ObservableList<Commande> historiqueCommandes = FXCollections.observableArrayList();
    private final Map<String, Integer> commandeEnCours = new HashMap<>();
    private final String nomServeur = "Sara"; // Nom du serveur

    @Override
    public void start(Stage stage) {
        // Configuration de la ComboBox pour les plats
        ComboBox<String> comboPlats = new ComboBox<>(FXCollections.observableArrayList("Pizza", "Pâtes", "Salade"));
        comboPlats.setPromptText("Choisir un plat");

        // Configuration du champ de quantité
        TextField quantiteField = new TextField();
        quantiteField.setPromptText("Quantité");

        // Bouton pour ajouter un plat
        Button ajouterButton = new Button("Ajouter au panier");

        // TableView pour l'historique des commandes
        TableView<Commande> table = new TableView<>();
        TableColumn<Commande, String> colonnePlat = new TableColumn<>("Plat");
        colonnePlat.setCellValueFactory(new PropertyValueFactory<>("plat"));

        TableColumn<Commande, Integer> colonneQuantite = new TableColumn<>("Quantité");
        colonneQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        TableColumn<Commande, Double> colonnePrix = new TableColumn<>("Prix total");
        colonnePrix.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));

        table.getColumns().addAll(colonnePlat, colonneQuantite, colonnePrix);
        table.setItems(historiqueCommandes);

        // Bouton pour valider la commande
        Button commanderButton = new Button("Valider la commande");

        // Label pour afficher le nom du serveur
        Label serveurLabel = new Label("Serveur : " + nomServeur);
        serveurLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Gestion des événements
        ajouterButton.setOnAction(e -> {
            String plat = comboPlats.getValue();
            int quantite = Integer.parseInt(quantiteField.getText());
            commandeEnCours.merge(plat, quantite, Integer::sum);

            // Ajouter la commande à l'historique
            double prixTotal = getPrixPlat(plat) * quantite;
            historiqueCommandes.add(new Commande(plat, quantite, prixTotal));

            // Actualiser la quantité
            quantiteField.clear();
        });

        commanderButton.setOnAction(e -> {
            CaisseClient client = new CaisseClient(nomServeur);
            client.envoyerCommande(commandeEnCours);
            commandeEnCours.clear();
            historiqueCommandes.clear();
        });

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(serveurLabel, comboPlats, quantiteField, ajouterButton, table, commanderButton);

        // Charger l'image de fond
        Image backgroundImage = new Image("/background.jpeg"); // Remplacez par le chemin de votre image
        BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        root.setBackground(new Background(bgImage));

        // Appliquer le CSS
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Afficher la fenêtre
        stage.setTitle("Système de Caisse - " + nomServeur);
        stage.setScene(scene);
        stage.show();
    }

    private double getPrixPlat(String nomPlat) {
        return switch (nomPlat) {
            case "Pizza" -> 12.0;
            case "Pâtes" -> 10.0;
            case "Salade" -> 8.0;
            default -> 0.0;
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}