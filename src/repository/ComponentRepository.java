package repository;


import model.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ComponentRepository {
    Optional<List<Component>> getComponentOfProject(int projectId);
    Component mapResultSetToComponent(ResultSet rs) throws Exception;
}