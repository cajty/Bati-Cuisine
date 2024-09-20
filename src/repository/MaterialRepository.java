package repository;

import model.Material;

import java.sql.ResultSet;
import java.util.Optional;

public interface MaterialRepository {
    Optional<Material> addMaterial(Material material);

    Material mapResultSetToMaterial(ResultSet rs) throws Exception;



    //    Material getMaterialOfComponent(int componentId);


}
