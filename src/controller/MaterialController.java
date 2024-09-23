package controller;

import model.Material;
import service.MaterialService;
import java.util.List;
import java.util.Optional;

public class MaterialController {
    private final MaterialService materialService = new MaterialService();

    public boolean addMaterial(model.Material material) {
        return materialService.addMaterial(material);
    }

    public List<Material> getMaterialOfProject(int projectId) {

        if(materialService.getMaterialOfProject(projectId).isPresent()){
            return materialService.getMaterialOfProject(projectId).get();
        }
        return null;
    }

}
