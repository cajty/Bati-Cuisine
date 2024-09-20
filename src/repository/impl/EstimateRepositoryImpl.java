package repository.impl;

import model.Estimate;
import repository.EstimateRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Optional;

public class EstimateRepositoryImpl implements EstimateRepository {
    public Optional<Estimate> addEstimate(Estimate estimate){
        return Optional.empty();
    }
    public Optional<Estimate> getEstimateOfProject(int projectId){
        return Optional.empty();

    }
    public Estimate mapResultSetToEstimate(ResultSet rs) throws Exception{

        return new Estimate(rs.getInt("estimate_id"),
                 rs.getDouble("estimated_amount"),
                 rs.getDate("issue_date"),
                 rs.getDate("validity_date"),
                 rs.getBoolean("is_accepted"),
                 rs.getInt("project_id"));

    }
}
