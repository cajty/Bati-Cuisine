package ui;

import model.Material;

import java.util.List;

public class MaterialCost {
    private  double materialPCost = 0;
    private  double materialPCostWithVat = 0;

    public void showMaterialCost(List<Material> materialsOfProject, double vatRate) {

        System.out.println("==================Coût des matériaux :===================");

        for (Material material : materialsOfProject) {
            double materialCost = material.getUnitCost() * material.getQuantity() * material.getQualityCoefficient() + material.getTransportCost();
            materialPCost += materialCost;

            System.out.printf("- %s : %.2f € (quantité : %.2f, coût unitaire : %.2f €, qualité : %.2f, transport : %.2f €)%n",
                    material.getName(),
                    materialCost,
                    material.getQuantity(),
                    material.getUnitCost(),
                    material.getQualityCoefficient(),
                    material.getTransportCost()
            );
        }
        System.out.println("\n\n\n==============================================\n");

        materialPCostWithVat = materialPCost * (1 + vatRate / 100);

        System.out.printf("%nCoût total : %.2f €%n", materialPCost);
        System.out.printf("Coût total avec TVA (%.2f%%) : %.2f €%n", vatRate, materialPCostWithVat);
        System.out.println("\n==============================================\n");

    }

    public  double getMaterialCost() {
        return materialPCost;
    }

    public  double getMaterialWithVat() {
        return materialPCostWithVat;
    }




}