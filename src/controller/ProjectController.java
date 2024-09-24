package controller;


import model.Project;
import service.ProjectService;

public class ProjectController {
    private static final ProjectService projectSrv = new ProjectService();


    public  void showExistingProjects() {
        projectSrv.showExistingProjects();
    }
    public Project addProject(String projectName, int clientId) {
        Project  project = new Project(projectName, clientId);
        return projectSrv.addProject(project);

    }

    public void addCostAndmarginProfitToProject(int projectId, double cost, double marginProfit) {
        projectSrv.addCostAndmarginProfitToProject(projectId, cost, marginProfit);
    }

}
