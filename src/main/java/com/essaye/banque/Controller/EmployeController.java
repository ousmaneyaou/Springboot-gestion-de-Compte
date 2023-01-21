package com.essaye.banque.Controller;

import com.essaye.banque.Service_ou_Metier.EnployeMetier;
import com.essaye.banque.entities.Enploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeController {
    @Autowired
    private EnployeMetier enployeMetier;
    //juste apres on cree les delegate methode

    @RequestMapping(value = "/employes", method = RequestMethod.POST)
    public Enploye saveEnploye(@RequestBody Enploye e) {
        return enployeMetier.saveEnploye(e);
    }
    @RequestMapping(value = "/employes", method = RequestMethod.GET)
    public List<Enploye> listEnploye() {
        return enployeMetier.listEnploye();
    }
}
