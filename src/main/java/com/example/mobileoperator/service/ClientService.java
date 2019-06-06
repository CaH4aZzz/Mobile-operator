package com.example.mobileoperator.service;

import com.example.mobileoperator.model.Client;
import com.example.mobileoperator.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Data
@AllArgsConstructor
public class ClientService {

    private ClientRepository repository;

    public List<Client> getAll() {
        log.info("in " + this.toString());
        return repository.findAll();
    }

    public Optional<Client> getOneById(Long id) {
        return repository.findById(id);
    }

    public Client add(Client client) {
        return repository.save(client);
    }
}
