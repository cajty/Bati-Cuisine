package ui;

import controller.ProjectController;
import controller.ClientController;
import model.Client;
import util.ScannerSingleton;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private static final Scanner input = ScannerSingleton.getScanner();
    private static final ProjectController projectController = new ProjectController();
    private static final ClientController clientController = new ClientController();

    public static void mainMenu() {
        int userInput;

        do {
            System.out.println("\n=== Menu  ===" +
                    "\n1. Créer un nouveau projet" +
                    "\n2. Afficher les projets existants" +
                    "\n3. Calculer le coût d'un projet" +
                    "\n4. Quitter" +
                    "\nChoisissez une option :");

            userInput = getValidInput();

            switch (userInput) {
                case 1:
                    createNewProject();
                    break;
                case 2:
                    projectController.showExistingProjects();
                    break;
                case 3:
                    projectController.calculateProjectCost();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (userInput != 4);
    }

    private static void createNewProject() {
        System.out.println("--- Recherche de client ---");
        Optional<Client> clientOpt = searchOrAddClient();

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.println("--- Création d'un Nouveau Projet ---");
            System.out.print("Entrez le nom du projet : ");
            String projectName = input.nextLine();

             projectController.addProject(projectName, client.getClientId());
//            projectController.addComponent();
        } else {
            System.out.println("Aucun client sélectionné. Retour au menu principal.");
        }
    }

    private static int getValidInput() {
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
        }
        return input.nextInt();
    }
    private static Optional<Client> searchOrAddClient() {
     do {
         System.out.println("1. Rechercher un client existant");
         System.out.println("2. Ajouter un nouveau client");
         System.out.println("3. Retour au menu principal");
         System.out.print("Choisissez une option : ");
         int choice = getValidInput();
         switch (choice) {
             case 1:
                 System.out.print("Entrez le nom du client : ");
                 String clientName = input.nextLine();
                 return searchClient();
             case 2:
                 return addClient();
             case 3:
                 return Optional.empty();
             default:
                 System.out.println("Choix invalide. Veuillez réessayer.");
         }
     } while (true);
    }

    private static Optional<Client> addClient() {
        input.nextLine();
    System.out.print("Entrez le nom du client : ");
    String name = input.nextLine();

    System.out.print("Entrez l'adresse du client : ");
    String address = input.nextLine();

    System.out.print("Entrez le numéro de téléphone du client : ");
    String phone = input.nextLine();

    boolean isProfessional = false;
    while (true) {
        System.out.print("Le client est-il un professionnel ? (true/false) : ");
        String isProfessionalInput = input.nextLine();
        if (isProfessionalInput.equalsIgnoreCase("true") || isProfessionalInput.equalsIgnoreCase("false")) {
            isProfessional = Boolean.parseBoolean(isProfessionalInput);
            break;
        } else {
            System.out.println("Entrée invalide. Veuillez entrer 'true' ou 'false'.");
        }
    }

    return clientController.addClient(
            new Client(name, address, phone, isProfessional)
    );
}

        private static Optional<Client> searchClient() {
            input.nextLine();
            System.out.print("Entrez le nom du client : ");
            String name = input.nextLine();
            return clientController.searchClient(name);
        }


}
