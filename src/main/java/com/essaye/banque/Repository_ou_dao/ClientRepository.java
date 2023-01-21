package com.essaye.banque.Repository_ou_dao;

import com.essaye.banque.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
