package com.essaye.banque.Controller;

import com.essaye.banque.Service_ou_Metier.CompteMetier;
import com.essaye.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteController {
    @Autowired
    private CompteMetier comptemetier;

    @RequestMapping(value = "/comptes", method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte cp) {
        return comptemetier.saveCompte(cp);
    }
    @RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String code) {
        return comptemetier.getCompte(code);
    }
}
