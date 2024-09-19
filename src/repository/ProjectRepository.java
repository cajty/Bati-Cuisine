package repository;

import model.Project;

import java.sql.ResultSet;
import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> addProject(Project project );

    Project mapResultSetToProject(ResultSet rs) throws Exception;

}
