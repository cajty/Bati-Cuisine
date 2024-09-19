package repository.impl;

import model.Client;

import java.sql.ResultSet;
import java.util.Optional;

public class ClientRepositoryImpl implements repository.ClientRepository {

    public  Optional<Client> addClient(Client client){
        return Optional.of(client);
    }
    public  Optional<Client> getClientOfProject(int projectId){
        return Optional.empty();
    }
    public Optional<Client> getClientByName(String name){
        return Optional.empty();
    }
     public Client mapResultSetToClient(ResultSet rs) throws Exception{
          int clientId = rs.getInt("client_id");
          String name = rs.getString("name");
          String address = rs.getString("address");
          String phone  = rs.getString("phone");
          boolean isProfessional  = rs.getBoolean("is_professional");
          return new Client(clientId, name, address, phone, isProfessional);
     }
}
