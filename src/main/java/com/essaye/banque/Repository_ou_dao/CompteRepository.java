package com.essaye.banque.Repository_ou_dao;

import com.essaye.banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {
}

