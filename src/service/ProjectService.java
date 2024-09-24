package service;

import model.Project;
import repository.ProjectRepository;
import repository.impl.ProjectRepositoryImpl;

import java.util.Optional;


public class ProjectService {
    private static final ProjectRepository projectRepository = new ProjectRepositoryImpl();

public Project addProject(Project project) {
    Optional<Project> newProject = projectRepository.addProject(project);
    if (newProject.isPresent()) {

        return newProject.get();

    } else {
        return null;

    }

}
    public void showExistingProjects() {
        projectRepository.getAllProjects().ifPresent(projects -> {
            for (Project project : projects) {
                System.out.println(project);
            }
        });
    }

    public void addCostAndmarginProfitToProject(int projectId, double cost, double marginProfit) {
        projectRepository.addCostAndmarginProfitToProject(projectId, cost, marginProfit);
    }

}
