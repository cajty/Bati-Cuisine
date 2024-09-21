package repository;

import model.Client;

import java.sql.ResultSet;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> addClient(Client client);
    Optional<Client> getClientOfProject(int projectId);
    Optional<Client> getClientById(int clientId);
    Optional<Client> getClientByName(String name);
    Client mapResultSetToClient(ResultSet rs) throws Exception;
}
