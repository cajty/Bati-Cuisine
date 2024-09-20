package repository.impl;

import model.Labor;


import java.sql.ResultSet;
import java.util.Optional;

public class LaborRepositoryImpl implements repository.LaborRepository {

    public Optional<Labor> addLabor(Labor labor){
        return Optional.empty();
    }

    public Labor mapResultSetToLabor(ResultSet rs) throws Exception{


        return new Labor( rs.getInt("labor_id"),
                rs.getInt("component_id"),
                rs.getDouble("hourly_rate"),
                rs.getDouble("work_hours"),
                rs.getDouble("worker_productivity"),
                rs.getString("labor_type"));

    }


}
