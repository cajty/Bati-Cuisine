package repository.impl;

import model.Material;
import repository.MaterialRepository;

import java.sql.ResultSet;
import java.util.Optional;

public class MaterialRepositoryImpl implements MaterialRepository {
    @Override
    public Optional<Material> addMaterial(Material material){
        return Optional.empty();
    }
    @Override
    public Material mapResultSetToMaterial(ResultSet rs) throws Exception{

        return new Material(
                rs.getString("name"),
                rs.getDouble("vat_rate"),
                rs.getDouble("unit_cost"),
                rs.getDouble("quantity"),
                rs.getDouble("transport_cost"),
                rs.getDouble("quality_coefficient"));
    }
}
