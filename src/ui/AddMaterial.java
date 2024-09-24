package ui;

import controller.MaterialController;
import model.ComponentType;
import model.Material;
import util.Helper;

import java.util.Scanner;

public class AddMaterial {


    private final MaterialController materialController;
    private   static   Scanner input ;


    public AddMaterial(Scanner input, MaterialController materialController) {
        this.materialController = materialController;
        this.input = input;

    }

    public   void addMaterial(int projectId) {

        System.out.println("\n========= Ajout de matériau : =========\n\n");
        while (true) {
            System.out.print("Entrez le nom du matériau : ");
            String name = input.nextLine();
            System.out.print("Entrez le taux de TVA : ");
            double vatRate = Helper.getValidDoubleInput();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coût unitaire : ");
            double unitCost = Helper.getValidDoubleInput();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez la quantité : ");
            double quantity = Helper.getValidDoubleInput();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coût de transport : ");
            double transportCost = Helper.getValidDoubleInput();
            input.nextLine(); // Consume newline left-over
            System.out.print("Entrez le coefficient de qualité : ");
            double qualityCoefficient = Helper.getValidDoubleInput();
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