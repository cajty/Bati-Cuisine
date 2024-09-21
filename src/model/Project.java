package model;

public class Project {

    private int projectId;
    private String projectName;
    private double profitMargin;
    private double totalCost;
    private ProjectStatus projectStatus; // Changed from String to ProjectStatus
    private int clientId;

    public Project(int projectId,String projectName, double profitMargin, double totalCost, ProjectStatus projectStatus, int clientId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.projectStatus = projectStatus;
        this.clientId = clientId;

    }



    public Project( String projectName, int clientId) {
        this.projectName = projectName;
        this.clientId = clientId;
    }



    public int getProjectId() { return projectId; }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", profitMargin=" + profitMargin +
                ", totalCost=" + totalCost +
                ", projectStatus=" + projectStatus +
                ", clientId=" + clientId +
                '}';
    }
}