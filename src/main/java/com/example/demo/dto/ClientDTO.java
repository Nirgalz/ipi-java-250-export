package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Kayne on 09/04/2018.
 */
public class ClientDTO {

    private Long id;

    private String prenom;

    private String nom;

    private List<FactureDTO> factures = new ArrayList<>();

    public List<FactureDTO> getFactures() {
        return factures;
    }

    public void setFactures(List<FactureDTO> factures) {
        this.factures = factures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
