package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private FactureMapper factureMapper;

    public List<ClientDTO> findAllClients() {
        return clientRepository.findAll().stream().map(c-> clientMapper.map(c)).collect(toList());
    }

    public ClientDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::map)
                .orElseThrow(() ->
                        new IllegalArgumentException("Client inconnu " + id)
                );
    }

    public List<FactureDTO> findFacturesByClientId(Long id){
        ClientDTO client = this.findById(id);

        return client.getFactures().stream().map(c-> factureMapper.map(c)).collect(toList());
    }
}
