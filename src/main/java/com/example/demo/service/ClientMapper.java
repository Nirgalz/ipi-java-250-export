package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;



/**
 * Mapper pour transformer un Client en ClientDTO. Car on ne veut utiliser les objets Entity (JPA/Hibernate) en dehors de la couche service.
 */
@Component
public class ClientMapper {

    @Autowired
    private FactureMapper factureMapper;

    public ClientDTO map(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setFactures(entity.getFactures().stream().map(factureMapper::map).collect(toList()));
        return dto;
    }
}
