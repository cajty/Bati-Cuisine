package service;

import model.Estimate;
import repository.impl.EstimateRepositoryImpl;

import java.util.Optional;

public class EstimateService {
    private static final EstimateRepositoryImpl EstimateRepository = new EstimateRepositoryImpl();

    public Optional<Estimate> addEstimate(model.Estimate estimate) {
        return EstimateRepository.addEstimate(estimate);
    }

}
