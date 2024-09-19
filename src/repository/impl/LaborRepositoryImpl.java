package repository.impl;

import model.Labor;


import java.sql.ResultSet;
import java.util.Optional;

public class LaborRepositoryImpl implements repository.LaborRepository {

    public Optional<Labor> addLabor(Labor labor){
        return Optional.empty();
    }

    public Labor mapResultSetToLabor(ResultSet rs) throws Exception{

        int laborId = rs.getInt("labor_id");
        int componentId = rs.getInt("component_id");
        double hourlyRate = rs.getDouble("hourly_rate");
        double workHours = rs.getDouble("work_hours");
        double workerProductivity = rs.getDouble("worker_productivity");
        String laborType = rs.getString("labor_type");
        return new Labor( laborId,  componentId,  hourlyRate,  workHours,  workerProductivity,  laborType);

    }


}
