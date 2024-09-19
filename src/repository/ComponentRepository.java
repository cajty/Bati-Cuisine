package repository;

import model.Component;

import java.util.List;
import java.util.Optional;

public interface ComponentRepository {
    Optional<List<Component>> getComponentOfProject(int projectId);
}