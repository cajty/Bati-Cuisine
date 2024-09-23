package ui;

import controller.MaterialController;
import model.ComponentType;
import model.Material;

import java.util.Scanner;

public class MaterialMenu {


    private final MaterialController materialController;
    private   static   Scanner input ;


    public MaterialMenu(Scanner input, MaterialController materialController) {
        this.materialController = materialController;
        this.input = input;

    }

    public   void addMaterial(int projectId) {
        while (true) {
            System.out.print("Entrez le nom du matériau : ");
            String name = input.nextLine();
            System.out.print("Entrez le taux de TVA : ");
            double vatRate = input.nextDouble();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coût unitaire : ");
            double unitCost = input.nextDouble();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez la quantité : ");
            double quantity = input.nextDouble();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coût de transport : ");
            double transportCost = input.nextDouble();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coefficient de qualité : ");
            double qualityCoefficient = input.nextDouble();
            input.nextLine(); // Consume newline left-over

            Material material = new Material(name, ComponentType.MATERIAL, vatRate, projectId, unitCost, quantity, transportCost, qualityCoefficient);
            if (materialController.addMaterial(material)) {
                System.out.println("Matériau ajouté avec succès.");
            } else {
                System.out.println("Échec de l'ajout du matériau.");
            }

            System.out.print("Voulez-vous ajouter un autre matériau ? (y/n) : ");
            String response = input.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}