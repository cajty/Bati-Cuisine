

import model.ComponentType;
import model.Labor;
import repository.impl.LaborRepositoryImpl;
import ui.Menu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LaborRepositoryImpl laborRepository = new LaborRepositoryImpl();

        Labor labor = new Labor("Labor3", ComponentType.LABOR, 0.2, 1,
                10, 10, 10, "Type1");



        if(laborRepository.addLabor(labor)){
            System.out.println("Labor added successfully");
        }else{
            System.out.println("Labor not added");
        }

        laborRepository.getLaborOfProject(1).ifPresent(labors -> {
            for (Labor l : labors) {
                System.out.println(l);
            }
        });




    }
}