package controller;

import model.Client;
import service.ClientService;


import java.util.Optional;


public class ClientController {
    private static final ClientService clientSev = new ClientService();


    public Optional<Client> addClient( Client client) {

        return clientSev.addClient(client);
    }


    public Optional<Client> searchClient( String name) {

        Optional<Client> client = clientSev.searchClient(name);
        if (client.isPresent()) {
            System.out.println("Client found: " + client.get());
        } else {
            System.out.println("Client not found");
        }
        return client;
    }

}
