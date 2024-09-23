package service;

import model.Labor;
import repository.LaborRepository;
import repository.impl.LaborRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class LaborService {
    private static final LaborRepository laborRepository = new LaborRepositoryImpl();


    public boolean  addLabor( Labor labor){
        return laborRepository.addLabor(labor);
    }

    public Optional<List<Labor>> getLaborOfProject(int projectId) {
        return laborRepository.getLaborOfProject(projectId);
    }
}
