package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.entities.Client;

import java.util.List;

public interface ClientService {
    public Client saveClient(Client client);
    public List<Client> listeClient(); //operation qui retourne la liste des clients
}
