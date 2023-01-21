package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.entities.Enploye;

import java.util.List;

public interface EnployeMetier {
    public Enploye saveEnploye(Enploye e);
    public List<Enploye> listEnploye();
}
