package repository;

import model.Material;

import java.util.Optional;

public interface MaterialRepository {
    Optional<Material> addMaterial(Material material);
//    Material getMaterialOfComponent(int componentId);
}
