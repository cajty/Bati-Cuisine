package ui;

import controller.*;
import model.Client;
import model.Estimate;
import model.Project;
import util.Helper;
import util.ScannerSingleton;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private static final Scanner input = ScannerSingleton.getScanner();
    private static final ProjectController projectController = new ProjectController();
    private static final ClientController clientController = new ClientController();
    private static final MaterialController materialController = new MaterialController();
    private static final LaborController laborController = new LaborController();
    private static final EstimateController estimateController = new EstimateController();

    private AddLabor addLabor = new AddLabor(input,laborController);
    private AddMaterial addMaterial = new AddMaterial(input,materialController);

    private LaborCost laborCost = new LaborCost();
    private MaterialCost materialCost = new MaterialCost();


    public  void start() {
        int userInput;

        do {
            System.out.println("\n=== Menu  ===" +
                    "\n1. Créer un nouveau projet" +
                    "\n2. Afficher les projets existants" +
                    "\n3. Calculer le coût d'un projet" +
                    "\n4. Quitter" +
                    "\nChoisissez une option :");

            userInput = Helper.getValidNumberInput();

            switch (userInput) {
                case 1:
                    createNewProject();
                    break;
                case 2:
                    projectController.showExistingProjects();
                    break;
                case 3:
                        int projectId = Helper.geProjectIdFromUser();
                        calculterCostProject(projectId);
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

    private  void createNewProject() {
        System.out.println("--- Recherche de client ---");
        Optional<Client> clientOpt = searchOrAddClient();

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.println("Client trouvé :\n " + client.getName());
            System.out.println("Souhaitez-vous continuer avec ce client ? (y/n) :" );
            String continueWithClient = input.nextLine();
            if (!continueWithClient.equalsIgnoreCase("y")) {
                System.out.println("Retour au menu principal.");
                return;
            }

            System.out.println("--- Création d'un Nouveau Projet ---");
            System.out.print("Entrez le nom du projet : ");
            String projectName = input.nextLine();

           Project project = projectController.addProject(projectName, client.getClientId());
            addMaterial.addMaterial(project.getProjectId());
            addLabor.addLabor(project.getProjectId());

            calculterCostProject(project.getProjectId());

        } else {
            System.out.println("Aucun client sélectionné. Retour au menu principal.");
        }
    }



      



    private static Optional<Client> searchOrAddClient() {
     do {
         System.out.println("1. Rechercher un client existant");
         System.out.println("2. Ajouter un nouveau client");
         System.out.println("3. Retour au menu principal");
         System.out.print("Choisissez une option : ");
         int choice = Helper.getValidNumberInput();
         switch (choice) {
             case 1:
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


        public void calculterCostProject(int projectId) {

            double tva = askForVAT();
            double profitMargin = askForProfitMargin();

           Client client  = clientController.getClientOfProject(projectId);



            laborCost.showlaborCost(laborController.getMaterialOfProject(projectId), tva);

            materialCost.showMaterialCost(materialController.getMaterialOfProject(projectId), tva);

            double amount = laborCost.getLaborCostWithVat() + materialCost.getMaterialWithVat() * (1 + profitMargin / 100);

            if(client.isProfessional()) {
                amount = amount * 0.9;     // 10% discount for professional clients
            }
            System.out.println("Le coût total du projet est de : " + amount + " €");

            addEstimate(projectId ,amount, profitMargin);



        }


        private boolean addEstimate(int projectId , double amount , double profitMargin) {



        LocalDate[] dates = Helper.inputAndValidateDates();
        System.out.println("ouhaitez-vous enregistrer le devis ? (y/n):");
        String saveEstimate = input.nextLine();
        if (saveEstimate.equalsIgnoreCase("y")) {
            Estimate estimate  = new Estimate(amount, dates[0], dates[1], projectId);
            estimateController.addEstimate(estimate).toString();
            projectController.addCostAndmarginProfitToProject(projectId, amount, profitMargin );

            return true;
        }
        return false;

    }







    private double askForVAT() {
        input.nextLine();
    System.out.print("Souhaitez-vous appliquer une TVA au projet ? (y/n) : ");
    String applyVAT = input.nextLine();
    if (applyVAT.equalsIgnoreCase("y")) {
        System.out.print("Entrez le pourcentage de TVA (%) : ");
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.print("Entrée invalide. Veuillez entrer un nombre : ");
        }
        double vatPercentage = Helper.getValidDoubleInput();
        input.nextLine();
        return vatPercentage;
    }
    return 0;
}


    private double askForProfitMargin() {
    System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) : ");
    String applyMargin = input.nextLine();
    if (applyMargin.equalsIgnoreCase("y")) {
        System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.print("Entrée invalide. Veuillez entrer un nombre : ");
        }
        double marginPercentage = Helper.getValidDoubleInput();
        input.nextLine();
        return marginPercentage;
    }
    return 0;
}





}






