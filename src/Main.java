

import model.ComponentType;
import model.Labor;
import model.Material;
import repository.MaterialRepository;
import repository.impl.LaborRepositoryImpl;
import repository.impl.MaterialRepositoryImpl;
import ui.Menu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LaborRepositoryImpl laborRepository = new LaborRepositoryImpl();
        MaterialRepositoryImpl materialRepository = new MaterialRepositoryImpl();

        Labor labor = new Labor("Labor3", ComponentType.LABOR, 0.2, 1,
                10, 10, 10, "Type1");

        Material material1 = new Material("Material3", ComponentType.MATERIAL, 0.2, 1,
                10, 10, 10, 10);
        Material material2 = new Material("Material4", ComponentType.MATERIAL, 0.2, 1,
                10, 10, 10, 10);
        if(materialRepository.addMaterial(material1)){
            System.out.println("1 added successfully");
        }else{
            System.out.println("1 not added");
        }
        if (materialRepository.addMaterial(material2)){
            System.out.println("2 added successfully");
        }else{
            System.out.println("2 not added");
        }

        laborRepository.getLaborOfProject(1).ifPresent(labors -> {
            for (Labor l : labors) {
                System.out.println(l);
            }
        });
        materialRepository.getMaterialOfProject(1).ifPresent(materials -> {
            for (Material m : materials) {
                System.out.println(m);
            }
        });




    }
}