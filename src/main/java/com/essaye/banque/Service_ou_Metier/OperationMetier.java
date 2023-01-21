package com.essaye.banque.Service_ou_Metier;

public interface OperationMetier {
    public boolean verser(String code, double montant, Long codeEmpoye);
    public boolean retirer(String code, double montant, Long codeEmpoye);
    public boolean virement(String cpte1,String cpte2, double montant, Long codeEmpoye);

    public PageOperation getOperation(String codeCompte, int page, int size);
}
