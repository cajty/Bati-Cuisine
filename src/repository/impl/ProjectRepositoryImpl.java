package repository.impl;

import model.Project;
import model.ProjectStatus;
import util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProjectRepositoryImpl implements repository.ProjectRepository {

  public Optional<Project> addProject(Project project) {
    String sql = "INSERT INTO projects (project_name, client_id) VALUES (?, ?)";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, project.getProjectName());
        ps.setInt(2, project.getClientId());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int projectId = rs.getInt(1);
            project.setProjectId(projectId);
            return Optional.of(project);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Optional.empty();
}

    public Optional<List<Project>> getAllProjects(){
        String sql = "SELECT * FROM projects";
        List<Project> projects = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                projects.add(mapResultSetToProject(rs));
            }
            return Optional.of(projects);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public boolean addCostAndmarginProfitToProject(int projectId, double cost, double marginProfit) {
        String sql = "UPDATE projects SET total_cost = ?, profit_margin = ? WHERE project_id = ?";
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, cost);
            ps.setDouble(2, marginProfit);
            ps.setInt(3, projectId);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Project mapResultSetToProject(ResultSet rs) throws Exception {
        return new Project(
                rs.getInt("project_id"),
                rs.getString("project_name"),
                rs.getDouble("profit_margin"),
                rs.getDouble("total_cost"),
                ProjectStatus.valueOf(rs.getString("project_status")),
                rs.getInt("client_id"));

    }
}
