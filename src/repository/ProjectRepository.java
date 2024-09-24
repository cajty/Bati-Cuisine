package repository;

import model.Project;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> addProject(Project project );
    Optional<List<Project>> getAllProjects();
    boolean addCostAndmarginProfitToProject(int projectId, double cost, double marginProfit);

    Project mapResultSetToProject(ResultSet rs) throws Exception;

}
