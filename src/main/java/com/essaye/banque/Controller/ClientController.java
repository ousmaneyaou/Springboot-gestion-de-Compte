package com.essaye.banque.Controller;

import com.essaye.banque.Service_ou_Metier.ClientService;
import com.essaye.banque.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // pour montrer que ce un controlleur
public class ClientController {
    @Autowired
    private ClientService clientService; // une methode permet d'ajouter et de consulter la liste
    @RequestMapping(value = "/Clients", method = RequestMethod.POST) // pour acceder a saveClient et la methode post ce pour ajouter
    public Client saveClient(@RequestBody Client client) {   //@RequestBody pour indiquer a spring que qu'il devrai requiperer les donnee du client dans le corps de la requette (si post)
        return clientService.saveClient(client); // ici on genere les delegate methode
    }
    @RequestMapping(value = "/Clients", method = RequestMethod.GET) // Get ce pour consulter
    public List<Client> listeClient() {
        return clientService.listeClient();
    }

}
