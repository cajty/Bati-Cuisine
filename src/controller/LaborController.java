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

    public Optional<List<Labor>> getMaterialOfProject(int projectId) {
        return laborService.getLaborOfProject(projectId);
    }
}
