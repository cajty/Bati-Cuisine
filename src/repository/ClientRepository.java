package repository;

import model.Client;

import java.util.Optional;

public interface ClientRepository {
    Optional<Client> addClient(Client client);
    Optional<Client> getClientOfProject(int projectId);
    Optional<Client> getClientByName(String name);
}
