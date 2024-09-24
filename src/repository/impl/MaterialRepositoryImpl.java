package repository.impl;

import model.Labor;
import model.Material;
import repository.MaterialRepository;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialRepositoryImpl implements MaterialRepository {
    private final Connection connection = DbConnection.getInstance().getConnection();
    @Override
    public boolean addMaterial(Material material){
        String sql = "WITH inserted_component AS (" +
                "INSERT INTO components (name, component_type, vat_rate, project_id) " +
                "VALUES (?, ?::component_type_enum, ?, ?) " +
                "RETURNING component_id" +
                ") " +
                "INSERT INTO materials (component_id, unit_cost, quantity, transport_cost, quality_coefficient) " +
                "VALUES ((SELECT component_id FROM inserted_component), ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, material.getName());
            ps.setString(2, material.getComponentType().toString());
            ps.setDouble(3, material.getVatRate());
            ps.setInt(4, material.getProjectId());
            ps.setDouble(5, material.getUnitCost());
            ps.setDouble(6, material.getQuantity());
            ps.setDouble(7, material.getTransportCost());
            ps.setDouble(8, material.getQualityCoefficient());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
    @Override
    public Optional<List<Material>> getMaterialOfProject(int projectId){
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT c.name ,c.vat_rate  , m.quantity , m.quality_coefficient , m.transport_cost , m.unit_cost FROM materials m " +
                "JOIN components c ON m.component_id = c.component_id" +
                " WHERE c.project_id = ? AND c.component_type = 'MATERIAL'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Material material = mapResultSetToMaterial(rs);
                materials.add(material);
            }
            return Optional.of(materials);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
