package repository.impl;

import model.Project;
import model.ProjectStatus;


import java.sql.ResultSet;
import java.util.Optional;

public class ProjectRepositoryImpl implements repository.ProjectRepository {
    public Optional<Project> addProject(Project project ){
        return Optional.empty();
    }

    public Project mapResultSetToProject(ResultSet rs) throws Exception{
         int projectId = rs.getInt("project_id");
         String projectName = rs.getString("project_name");
         double profitMargin  = rs.getDouble("profit_margin");
         double totalCost = rs.getDouble("total_cost");
         ProjectStatus projectStatus = ProjectStatus.valueOf(rs.getString("project_status"));
        int clientId = rs.getInt("client_id");

        return new Project(projectId, projectName, profitMargin, totalCost,projectStatus, clientId);

    }
}
