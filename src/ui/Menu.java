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
        Optional<Client> clientOpt = clientController.searchOrAddClient();

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


}
