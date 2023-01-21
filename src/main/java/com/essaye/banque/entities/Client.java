package com.essaye.banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClient;
    private String nomClient;
    @JsonIgnore // de preference à chaque fois qu'ilya une collectin metter @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)  //comme se en association bidirectionnelle on utilise mappeby et entre "" l'objet qui va etre declarrer la la classe compte
    private Collection<Compte> comptes; //fetch = FetchType.LAZY -->les comptes ne serons charger qu'en cas de besoin
}
