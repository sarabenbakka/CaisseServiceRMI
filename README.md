# Système de Caisse pour un Restaurant avec Java RMI et JavaFX

## Description
Ce projet est un système de gestion de caisse pour un restaurant, développé en utilisant Java RMI (Remote Method Invocation) pour la communication entre le client et le serveur, et JavaFX pour l'interface graphique. Le système permet aux serveurs du restaurant de passer des commandes à une caisse centrale, qui stocke les commandes et calcule les factures.

## Fonctionnalités
- **Ajout de commandes** : Les serveurs peuvent ajouter des commandes pour un client.
- **Historique des commandes** : Les commandes sont stockées et affichées dans un tableau.
- **Calcul des factures** : La caisse calcule la facture totale pour un serveur donné.
- **Interface graphique moderne** : Une interface intuitive et stylisée avec JavaFX.

## Prérequis
- **JDK 21** : Assurez-vous d'avoir Java Development Kit (JDK) 21 installé.
- **JavaFX SDK** : Téléchargez et configurez JavaFX SDK pour votre projet.
- **IDE** : Recommandé : IntelliJ IDEA ou Eclipse.

## Installation
1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/votre-utilisateur/votre-projet.git
   cd votre-projet
   ```

2. **Configurer JavaFX** :
   - Téléchargez JavaFX SDK depuis [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/).
   - Ajoutez les bibliothèques JavaFX à votre projet dans l'IDE.

3. **Configurer les VM options** :
   - Dans IntelliJ IDEA, allez dans `Run` > `Edit Configurations`.
   - Ajoutez les options suivantes dans `VM options` :
     ```
     --module-path "chemin/vers/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
     ```

4. **Lancer le serveur RMI** :
   - Exécutez la classe `CaisseRMIServer` pour démarrer le serveur.

5. **Lancer l'interface graphique** :
   - Exécutez la classe `CaisseGUI` pour démarrer l'interface client.

## Utilisation
1. **Ajouter une commande** :
   - Sélectionnez un plat dans la liste déroulante.
   - Entrez la quantité.
   - Cliquez sur "Ajouter au panier".

2. **Valider la commande** :
   - Cliquez sur "Valider la commande" pour envoyer la commande au serveur.

3. **Voir l'historique** :
   - Les commandes ajoutées sont affichées dans le tableau.

4. **Calculer la facture** :
   - La facture totale est calculée automatiquement et affichée.

## Structure du projet
```
src/
├── CaisseClient.java          # Client RMI pour envoyer des commandes
├── CaisseGUI.java             # Interface graphique JavaFX
├── CaisseRMIServer.java       # Serveur RMI pour gérer les commandes
├── CaisseService.java         # Interface RMI pour les méthodes distantes
├── CaisseServerImpl.java      # Implémentation du serveur RMI
├── Commande.java              # Classe pour représenter une commande
├── styles.css                 # Fichier CSS pour styliser l'interface
└── background.jpg             # Image de fond pour l'interface
```

## Captures d'écran
![Interface graphique](screenshot.png)
![Screenshot 2025-02-17 114351](https://github.com/user-attachments/assets/330a354a-2544-40c3-a608-b7c46a7341cf)
![image](https://github.com/user-attachments/assets/19bb83e0-7060-4f6a-b887-74a4a737ed7b)
![image](https://github.com/user-attachments/assets/8832ab76-f9f5-43aa-a65c-b4a25ef93c57)





### **Remarques supplémentaires**
- Assurez-vous que le serveur RMI est en cours d'exécution avant de démarrer l'interface graphique.
- Pour personnaliser l'interface, modifiez le fichier `styles.css`.


