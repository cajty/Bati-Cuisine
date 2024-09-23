package service;

import model.Material;
import repository.MaterialRepository;
import repository.impl.MaterialRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class MaterialService {
    private final MaterialRepository materialRepository = new MaterialRepositoryImpl();

    public boolean addMaterial(model.Material material) {
        return materialRepository.addMaterial(material);
    }

    public Optional<List<Material>> getMaterialOfProject(int projectId) {
        return materialRepository.getMaterialOfProject(projectId);
    }
}
