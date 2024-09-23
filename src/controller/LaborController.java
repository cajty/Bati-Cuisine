package controller;

import model.Labor;


import java.util.List;
import java.util.Optional;
import service.LaborService;

public class LaborController {
    private final LaborService laborService = new LaborService();

    public boolean addLabor(Labor labor) {
        return laborService.addLabor(labor);
    }

    public List<Labor> getMaterialOfProject(int projectId) {

        if(laborService.getLaborOfProject(projectId).isPresent()){
            return laborService.getLaborOfProject(projectId).get();
        }
        return null;
    }
}
