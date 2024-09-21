package controller;


import model.Project;
import service.ProjectService;

public class ProjectController {
    private static final ProjectService projectSrv = new ProjectService();

    public  void showExistingProjects() {
        projectSrv.showExistingProjects();
    }
    public void addProject(String projectName, int clientId) {
        Project  project = new Project(projectName, clientId);
        projectSrv.addProject(project);

        System.out.println("addProject");
    }

    public void calculateProjectCost() {
        System.out.println("calculateProjectCost");
    }

}
