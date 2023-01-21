package com.essaye.banque.Service_ou_Metier;
import com.essaye.banque.Repository_ou_dao.CompteRepository;
import com.essaye.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompteMetierImpl implements CompteMetier{
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte saveCompte(Compte cp) {
        cp.setDateCreation(new Date()); //utiliser la date system achaque creation d'un compte
        return compteRepository.save(cp);
    }

    @Override
    public Compte getCompte(String code) {
        return compteRepository.findById(code).orElse(null);
   }
}
