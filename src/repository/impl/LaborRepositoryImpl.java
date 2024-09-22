package repository.impl;

import model.ComponentType;
import model.Labor;
import util.DbConnection;

import java.sql.*;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LaborRepositoryImpl implements repository.LaborRepository {
    private final Connection connection = DbConnection.getInstance().getConnection();
    @Override
   public boolean addLabor(Labor labor){
    String sql = "WITH inserted_component AS (" +
            "INSERT INTO components (name, component_type, vat_rate, project_id) " +
            "VALUES (?, ?::component_type_enum, ?, ?) " +
            "RETURNING component_id" +
            ") " +
            "INSERT INTO labor (component_id, hourly_rate, work_hours, labor_type, worker_productivity) " +
            "VALUES ((SELECT component_id FROM inserted_component), ?, ?, ? ,?)";
    try {

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, labor.getName());
        ps.setString(2, labor.getComponentType().toString());
        ps.setDouble(3, labor.getVatRate());
        ps.setInt(4, labor.getProjectId());
        ps.setDouble(5, labor.getHourlyRate());
        ps.setDouble(6, labor.getWorkHours());
        ps.setString(7, labor.getLaborType());
        ps.setDouble(8, labor.getWorkerProductivity());
        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();

    }

   return false;
}

    public Optional<List<Labor>> getLaborOfProject(int projectId){
        List<Labor> labors = new ArrayList<>();
        String sql = "SELECT c.name ,c.vat_rate  , l.labor_type , l.work_hours , l.hourly_rate , l.worker_productivity FROM labor l " +
                "JOIN components c ON l.component_id = c.component_id" +
                " WHERE c.project_id = ? AND c.component_type = 'LABOR'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Labor labor = mapResultSetToLabor(rs);
                labors.add(labor);
            }
            return Optional.of(labors);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Labor mapResultSetToLabor(ResultSet rs) throws Exception{

        return new Labor(
                rs.getString("name"),
                rs.getDouble("vat_rate"),
                rs.getDouble("hourly_rate"),
                rs.getDouble("work_hours"),
                rs.getDouble("worker_productivity"),
                rs.getString("labor_type"));

    }


}
