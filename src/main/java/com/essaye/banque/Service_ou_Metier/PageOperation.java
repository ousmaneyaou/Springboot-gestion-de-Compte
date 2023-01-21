package com.essaye.banque.Service_ou_Metier;

import com.essaye.banque.entities.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class PageOperation implements Serializable {
    private List<Operation> operations;
    private int page;
    private int nombreOperation;
    private int totalOperation;
    private int totalPage;
}
