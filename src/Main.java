


import controller.LaborController;
import controller.MaterialController;
import ui.LaborCost;
import ui.LaborMenu;
import ui.MaterialCost;
import ui.Menu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.start();

        MaterialController materialController = new MaterialController();
        LaborController laborController = new LaborController();
        MaterialCost materialCost = new MaterialCost();
        LaborCost laborCost = new LaborCost();

        laborCost.showlaborCost(laborController.getMaterialOfProject(1), 20);

        materialCost.showMaterialCost(materialController.getMaterialOfProject(1), 20);







    }
}