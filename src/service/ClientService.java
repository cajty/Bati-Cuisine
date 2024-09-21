package service;

import model.Client;
import repository.ClientRepository;
import repository.impl.ClientRepositoryImpl;

import java.util.Optional;

public class ClientService {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    public Optional<Client> addClient(Client client) {
         return clientRepository.addClient(client);
    }
    public Optional<Client>  searchClient(String name) {
        return clientRepository.getClientByName(name);

    }
}
