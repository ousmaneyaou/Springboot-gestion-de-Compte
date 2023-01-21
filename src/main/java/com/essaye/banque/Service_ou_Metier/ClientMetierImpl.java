package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.Repository_ou_dao.ClientRepository;
import com.essaye.banque.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // pour instancier le bean
public class ClientMetierImpl implements ClientService{
    @Autowired //pour injecter l'implementation de cette interface
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listeClient() {
        return clientRepository.findAll();
    }
    // c'est pour l'implementation de l'interface cree ulterierement
}
