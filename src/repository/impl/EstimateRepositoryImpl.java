package repository.impl;

import model.Estimate;
import repository.EstimateRepository;
import util.DbConnection;

import java.sql.*;
import java.util.Optional;

public class EstimateRepositoryImpl implements EstimateRepository {
    private final Connection connection = DbConnection.getInstance().getConnection();

    @Override
    public Optional<Estimate> addEstimate(Estimate estimate) {
        String sql = "INSERT INTO estimates (estimated_amount, issue_date, validity_date, is_accepted, project_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, estimate.getEstimatedAmount());
            ps.setDate(2, new java.sql.Date(estimate.getIssueDate().getTime()));
            ps.setDate(3, new java.sql.Date(estimate.getValidityDate().getTime()));
            ps.setBoolean(4, estimate.isAccepted());
            ps.setInt(5, estimate.getProjectId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                return getEstimateById(generatedId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Estimate> getEstimateById(int projectId) {
        String sql = "SELECT * FROM estimates WHERE project_id = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapResultSetToEstimate(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();


        }
        return Optional.empty();
}

    @Override
    public Estimate mapResultSetToEstimate(ResultSet rs) throws Exception{

        return new Estimate(rs.getInt("estimate_id"),
                 rs.getDouble("estimated_amount"),
                 rs.getDate("issue_date"),
                 rs.getDate("validity_date"),
                 rs.getBoolean("is_accepted"),
                 rs.getInt("project_id"));

    }
}
