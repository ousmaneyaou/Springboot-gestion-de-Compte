package com.essaye.banque.Repository_ou_dao;//package com.essaye.banque.Repository_ou_dao;
import com.essaye.banque.entities.Enploye;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Enploye, Long> {
}
