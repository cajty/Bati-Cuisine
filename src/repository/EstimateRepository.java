package repository;

import model.Estimate;

import java.util.Optional;

public interface EstimateRepository {
    Optional<Estimate> addEstimate(Estimate estimate);
    Optional<Estimate> getEstimateOfProject(int projectId);
}
