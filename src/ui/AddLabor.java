package ui;

import controller.LaborController;
import model.ComponentType;
import model.Labor;

import java.util.Scanner;

public class AddLabor {

    private final LaborController laborController;
    private static  Scanner input;

    public AddLabor(Scanner input, LaborController laborController) {
        this.laborController = laborController;
        this.input = input;
    }

    public void addLabor(int projectId) {
        System.out.println("\n=================Ajout de la main-d'œuvre================\n\n");
        while (true) {
            System.out.print("Entrez le nom de la main-d'œuvre : ");
            String name = input.nextLine();
            System.out.print("Entrez le taux de TVA : ");
            double vatRate = input.nextDouble();
            input.nextLine();
            System.out.print("Entrez le coût horaire : ");
            double hourlyRate = input.nextDouble();
            input.nextLine();
            System.out.print("Entrez les heures de travail : ");
            double workHours = input.nextDouble();
            input.nextLine();
            System.out.print("Entrez la productivité des travailleurs : ");
            double workerProductivity = input.nextDouble();
            input.nextLine();
            System.out.print("Entrez le type de main-d'œuvre : ");
            String laborType = input.nextLine();

            Labor labor = new Labor(name, ComponentType.LABOR, vatRate, projectId, hourlyRate, workHours, workerProductivity, laborType);
            if (laborController.addLabor(labor)) {
                System.out.println("Main-d'œuvre ajoutée avec succès.");
            } else {
                System.out.println("Échec de l'ajout de la main-d'œuvre.");
            }

            System.out.print("Voulez-vous ajouter une autre main-d'œuvre ? (y/n) : ");
            String response = input.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}