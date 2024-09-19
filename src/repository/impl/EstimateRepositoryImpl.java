package repository.impl;

import model.Estimate;
import repository.EstimateRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Optional;

public class EstimateRepositoryImpl implements repository.EstimateRepository {
    public Optional<Estimate> addEstimate(Estimate estimate){
        return Optional.empty();
    }
    public Optional<Estimate> getEstimateOfProject(int projectId){
        return Optional.empty();

    }
    public Estimate mapResultSetToEstimate(ResultSet rs) throws Exception{
         int estimateId = rs.getInt("estimate_id");
         double estimatedAmount = rs.getDouble("estimated_amount");
         Date issueDate = rs.getDate("issue_date");
         Date validityDate = rs.getDate("validity_date");
         boolean isAccepted  = rs.getBoolean("is_accepted");
         int projectId = rs.getInt("project_id");


         return new Estimate(estimateId, estimatedAmount, issueDate, validityDate, isAccepted, projectId);

    }
}
