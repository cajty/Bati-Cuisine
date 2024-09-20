package repository.impl;

import model.Material;
import repository.MaterialRepository;

import java.sql.ResultSet;
import java.util.Optional;

public class MaterialRepositoryImpl implements MaterialRepository {

    public Optional<Material> addMaterial(Material material){
        return Optional.empty();
    }

    public Material mapResultSetToMaterial(ResultSet rs) throws Exception{

         int materialId = rs.getInt("material_id");
         int componentId = rs.getInt("component_id");
         double unitCost = rs.getDouble("unit_cost");
         double quantity = rs.getDouble("quantity");
         double transportCost = rs.getDouble("transport_cost");
         double qualityCoefficient =rs.getDouble("quality_coefficient");
        return new Material( materialId,  componentId,  unitCost,  quantity,  transportCost,  qualityCoefficient);
    }
}
