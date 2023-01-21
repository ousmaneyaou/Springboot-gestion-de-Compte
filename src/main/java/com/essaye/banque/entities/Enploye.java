package com.essaye.banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Enploye implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long codeEmpoye;
    private String nomEmploye;
    //@JsonIgnore // pour ignorer a l'affichage de la liste des employees
    //@JsonSetter //pour que les donnees en format json soit prise en compte
    @ManyToOne
    @JoinColumn(name = "code_enp_sup")
    private Enploye enployeSup;  //pour l'association reflexive
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "EMP_GR")
    private Collection<Groupe> groupes;

    @JsonIgnore  // pour ignorer a l'affichage de la liste des employees
    public Enploye getEnployeSup() {
        return enployeSup;
    }
    @JsonSetter  //pour que les donnees en format json soit prise en compte (dans la base)
    public void setEnployeSup(Enploye enployeSup) {
        this.enployeSup = enployeSup;
    }

}
