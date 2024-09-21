package repository.impl;

import model.Project;
import model.ProjectStatus;
import util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProjectRepositoryImpl implements repository.ProjectRepository {

  public Boolean addProject(Project project) {
    String sql = "INSERT INTO projects (project_name, client_id) VALUES (?, ?)";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, project.getProjectName());
        ps.setInt(2, project.getClientId());
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
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
