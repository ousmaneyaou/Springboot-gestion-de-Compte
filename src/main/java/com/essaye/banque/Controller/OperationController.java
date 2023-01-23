package com.essaye.banque.Controller;

import com.essaye.banque.Service_ou_Metier.OperationMetier;
import com.essaye.banque.Service_ou_Metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    @Autowired
    private OperationMetier operationMetier;
    //juste apres delegate methode
    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public PageOperation getOperation(@RequestParam String codeCompte, @RequestParam int page, @RequestParam int size) {
        return operationMetier.getOperation(codeCompte, page, size);
    }

    @RequestMapping(value = "/versement", method = RequestMethod.PUT)
    //on utilise @RequestParam comme c'estn'est pas un format json
    public boolean verser(@RequestParam String code,@RequestParam double montant, @RequestParam Long codeEmpoye) {
        return operationMetier.verser(code, montant, codeEmpoye);
    }
    @RequestMapping(value = "/retrait", method = RequestMethod.PUT)
    //on utilise @RequestParam comme c'estn'est pas un format json
    public boolean retirer(@RequestParam String code,@RequestParam double montant, @RequestParam Long codeEmpoye) {
        return operationMetier.retirer(code, montant, codeEmpoye);
    }
    @RequestMapping(value = "/virement", method = RequestMethod.PUT)
    public boolean virement(@RequestParam String cpte1, @RequestParam String cpte2, @RequestParam double montant, @RequestParam Long codeEmpoye) {
        return operationMetier.virement(cpte1, cpte2, montant, codeEmpoye);
    }
}
