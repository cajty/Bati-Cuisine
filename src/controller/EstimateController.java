package controller;




import service.EstimateService;

import java.util.Optional;

public class EstimateController {
  private static final EstimateService EstimateRepository = new EstimateService();

    public Optional<model.Estimate> addEstimate(model.Estimate estimate) {
        return EstimateRepository.addEstimate(estimate);
    }


}
