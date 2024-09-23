package ui;

import model.Labor;


import java.util.List;

public class LaborCost {
    private static double laborPCost = 0;
    private static double laborPCostWithVat = 0;

    public  void showlaborCost(List<Labor> laborOfProject, double vatRate) {

        laborOfProject.forEach(labor -> {
            double laborCost = labor.getHourlyRate() * labor.getWorkHours() * labor.getWorkerProductivity() ;
            laborPCost += laborCost;
            System.out.printf("- %s : %.2f € (quantité : %.2f h, coût horaire : %.2f €/h, productivité : %.2f)%n",
                    labor.getName(),
                    laborCost,
                    labor.getWorkHours(),
                    labor.getHourlyRate(),
                    labor.getWorkerProductivity()
            );

        });

        laborPCostWithVat = laborPCost * (1 + vatRate / 100);

        System.out.printf("%nCoût total : %.2f €%n", laborPCost);
        System.out.printf("Coût total avec TVA (%.2f%%) : %.2f €%n", vatRate, laborPCostWithVat);
    }

    public double getLaborCost() {
        return laborPCost;
    }

    public double getLaborCostWithVat() {
        return laborPCostWithVat;
    }


}
