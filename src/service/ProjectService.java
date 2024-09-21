package service;

import model.Project;
import repository.ProjectRepository;
import repository.impl.ProjectRepositoryImpl;

import java.util.Optional;


public class ProjectService {
    private static final ProjectRepository projectRepository = new ProjectRepositoryImpl();

public void addProject(Project project) {
    Optional<Project> newProject = projectRepository.addProject(project);
    if (newProject.isPresent()) {
        System.out.println("Project added successfully" + newProject.get());

    } else {
        System.out.println("Failed to add project");

    }

}
    public void showExistingProjects() {
        projectRepository.getAllProjects().ifPresent(projects -> {
            for (Project project : projects) {
                System.out.println(project);
            }
        });
    }

}
