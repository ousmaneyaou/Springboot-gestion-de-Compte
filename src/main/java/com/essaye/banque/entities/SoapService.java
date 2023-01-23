package com.essaye.banque.entities;

import com.essaye.banque.Repository_ou_dao.CompteRepository;
import com.essaye.banque.Repository_ou_dao.OperationRepository;
import com.essaye.banque.Service_ou_Metier.CompteMetier;
import com.essaye.banque.Service_ou_Metier.OperationMetier;
import com.essaye.banque.Service_ou_Metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService //pour que sa soit un web service
@Component //pour que spring puisse l'instansier
public class SoapService {

    @Autowired
    private CompteMetier compteMetier;
    @Autowired
    private OperationMetier operationMetier;
    @WebMethod
    public Compte getCompte(@WebParam(name = "code")String code) {
        return compteMetier.getCompte(code);
    }
    @WebMethod
    public boolean verser(@WebParam(name = "code")String code,
                          @WebParam(name = "montant")double montant,
                          @WebParam(name = "codeEmploye")Long codeEmpoye) {
        return operationMetier.verser(code, montant, codeEmpoye);
    }
    @WebMethod
    public boolean retirer(@WebParam(name = "code")String code,
                           @WebParam(name = "montant")double montant,
                           @WebParam(name = "codeEmploye")Long codeEmpoye) {
        return operationMetier.retirer(code, montant, codeEmpoye);
    }
    @WebMethod
    public boolean virement(@WebParam(name = "cpte1")String cpte1, @WebParam(name = "cpte2")String cpte2,
                            @WebParam(name = "montant")double montant,
                            @WebParam(name = "codeEmploye")Long codeEmpoye) {
        return operationMetier.virement(cpte1, cpte2, montant, codeEmpoye);
    }
    @WebMethod
    public PageOperation getOperation(@WebParam(name = "code")String codeCompte,
                                      @WebParam(name = "page")int page,
                                      @WebParam(name = "size")int size) {
        return operationMetier.getOperation(codeCompte, page, size);
    }

}
