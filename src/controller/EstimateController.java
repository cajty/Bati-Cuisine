package controller;




import model.Estimate;
import service.EstimateService;

import java.util.Optional;

public class EstimateController {
  private static final EstimateService EstimateRepository = new EstimateService();

    public Optional<Estimate> addEstimate(Estimate estimate) {
        return EstimateRepository.addEstimate(estimate);
    }


}
