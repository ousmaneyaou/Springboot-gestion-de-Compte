package com.essaye.banque.Service_ou_Metier;//package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.Repository_ou_dao.EmployeRepository;
import com.essaye.banque.entities.Enploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EnployeMetierImpl implements EnployeMetier{
    @Autowired
    private EmployeRepository enployeRepository;
    @Override
    public Enploye saveEnploye(Enploye e) {
        return enployeRepository.save(e);
    }

    @Override
    public List<Enploye> listEnploye() {
        return enployeRepository.findAll();
    }
}
