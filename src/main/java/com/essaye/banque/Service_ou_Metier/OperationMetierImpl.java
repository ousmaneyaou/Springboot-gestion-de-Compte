package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.Repository_ou_dao.CompteRepository;
import com.essaye.banque.Repository_ou_dao.EmployeRepository;
import com.essaye.banque.Repository_ou_dao.OperationRepository;
import com.essaye.banque.entities.*;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class OperationMetierImpl implements OperationMetier{
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    @Transactional // commeil ya des transaction
    public boolean verser(String code, double montant, Long codeEmpoye) {
        Compte cp = compteRepository.findById(code).orElse(null); // besoin du code compte
        Enploye ep = employeRepository.findById(codeEmpoye).orElse(null); // besoin du code employe
        Operation op = new Versement();
        op.setDateOperation(new Date()); //date de l'operation
        op.setMontant(montant);
        op.setCompte(cp);
        op.setEnploye(ep);
        operationRepository.save(op); // ajout des operation
        cp.setSolde(cp.getSolde()+montant); // mise a jour du compte
        return true;
    }

    @Override
    @Transactional
    public boolean retirer(String code, double montant, Long codeEmpoye) {
        Compte cp = compteRepository.findById(code).orElse(null); // besoin du code compte
        if (cp.getSolde()<montant)
            throw new RuntimeException("solde insuffisant");
        Enploye ep = employeRepository.findById(codeEmpoye).orElse(null); // besoin du code employe
        Operation op = new Retrait();
        op.setDateOperation(new Date()); //date de l'operation
        op.setMontant(montant);
        op.setCompte(cp);
        op.setEnploye(ep);
        operationRepository.save(op); // ajout des operation
        cp.setSolde(cp.getSolde()-montant); // mise a jour du compte
        return true;
    }

    @Override
    @Transactional
    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmpoye) {
        retirer(cpte1, montant, codeEmpoye);
        verser(cpte2, montant, codeEmpoye);
        return true;
    }

    @Override
    public PageOperation getOperation(String codeCompte, int page, int size) {
        //Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
        Page<Operation> ops = operationRepository.getOperations(codeCompte, PageRequest.of(page, size));
        PageOperation pOp= new PageOperation();
        pOp.setOperations(ops.getContent());
        pOp.setNombreOperation(ops.getNumberOfElements());
        pOp.setPage(ops.getNumber());
        pOp.setTotalOperation(ops.getTotalPages());
        pOp.setTotalOperation((int)ops.getTotalElements());
        return pOp;
    }
}
