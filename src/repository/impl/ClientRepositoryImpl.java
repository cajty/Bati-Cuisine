package repository.impl;

import model.Client;
import util.DbConnection;

import java.sql.*;



import java.sql.ResultSet;
import java.util.Optional;



public class ClientRepositoryImpl implements repository.ClientRepository {
@Override
public Optional<Client> addClient(Client client) {
    String sql = "INSERT INTO clients (name, address, phone, is_professional) VALUES (?, ?, ?, ?)";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, client.getName());
        ps.setString(2, client.getAddress());
        ps.setString(3, client.getPhone());
        ps.setBoolean(4, client.isProfessional());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            return getClientById(generatedId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Optional.empty();
}
@Override
public Optional<Client> getClientById(int clientId) {
    String sql = "SELECT * FROM clients WHERE client_id = ?";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, clientId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return Optional.of(mapResultSetToClient(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Optional.empty();
}
@Override
   public Optional<Client> getClientOfProject(int projectId) {
    String sql = "SELECT c.* FROM clients c JOIN projects p ON c.client_id = p.client_id WHERE p.project_id = ?";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, projectId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return Optional.of(mapResultSetToClient(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Optional.empty();
}


    @Override
public Optional<Client> getClientByName(String name) {
    String sql = "SELECT * FROM clients WHERE name = ?";
    try {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return Optional.of(mapResultSetToClient(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return Optional.empty();
}

     public Client mapResultSetToClient(ResultSet rs) throws Exception{
         return new Client(
                    rs.getInt("client_id"),
                 rs.getString("name"),
                 rs.getString("address"),
                 rs.getString("phone"),
                 rs.getBoolean("is_professional")
         );
     }
}
