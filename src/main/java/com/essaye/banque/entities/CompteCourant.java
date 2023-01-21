package com.essaye.banque.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("CC") // si on cree un compte le type est cc
public class CompteCourant  extends Compte{
    private double decouvert;
}
