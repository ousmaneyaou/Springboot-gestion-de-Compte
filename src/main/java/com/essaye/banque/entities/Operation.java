package com.essaye.banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1) //pour specifier la colonne (CE)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
        property = "type") //pour avoir le type quand on consulte
@JsonSubTypes({
        @JsonSubTypes.Type(name = "V", value = Versement.class),
        @JsonSubTypes.Type(name = "R", value = Retrait.class)
})
@Data @AllArgsConstructor @NoArgsConstructor
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    @JsonIgnore
    private Compte compte;
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private  Enploye enploye;

    @JsonIgnore
    public Enploye getEnploye() {
        return enploye;
    }
    @JsonSetter
    public void setEnploye(Enploye enploye) {
        this.enploye = enploye;
    }
}
