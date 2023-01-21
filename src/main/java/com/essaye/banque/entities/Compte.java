package com.essaye.banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //comme on na des classe derivees
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING, length = 2)  //comme ce une seule table
@Data
@AllArgsConstructor @NoArgsConstructor
//pour specifier le type du compte
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type") //pour faire le mapping objet json
@JsonSubTypes({
        @JsonSubTypes.Type(name = "CC", value = CompteCourant.class),
       @JsonSubTypes.Type(name = "CE", value = CompteEpargne.class)
})
public abstract class Compte implements Serializable {
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI") //pour la jointure
    private Client client; //--> un compte appartient a un client
    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private  Enploye enploye; //un compte et cree par un employe donc on declare un objet de type employe
    @JsonIgnore
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;  //un compte peut subir plusieur operation

}
