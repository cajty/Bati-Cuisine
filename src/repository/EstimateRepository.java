package repository;

import model.Estimate;

import java.sql.ResultSet;
import java.util.Optional;

public interface EstimateRepository {
    Optional<Estimate> addEstimate(Estimate estimate);
    Optional<Estimate> getEstimateById(int projectId);
    Estimate mapResultSetToEstimate(ResultSet rs) throws Exception;
}
