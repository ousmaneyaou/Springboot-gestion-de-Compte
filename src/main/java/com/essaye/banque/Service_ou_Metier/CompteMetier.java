package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.entities.Compte;
public interface CompteMetier {
    public Compte saveCompte(Compte cp);
    public Compte getCompte(String code);
  // cette methode permet de retourner un compte
}

