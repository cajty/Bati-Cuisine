package repository;

import model.Project;

import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> addProject(Project project );

}
