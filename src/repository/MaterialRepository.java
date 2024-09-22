package repository;

import model.Labor;
import model.Material;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface MaterialRepository {
    boolean addMaterial(Material material);
    Optional<List<Material>> getMaterialOfProject(int projectId);

    Material mapResultSetToMaterial(ResultSet rs) throws Exception;






}
