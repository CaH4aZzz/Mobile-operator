package com.example.mobileoperator.controller;

import com.example.mobileoperator.model.Client;
import com.example.mobileoperator.model.PhoneNumber;
import com.example.mobileoperator.service.ClientService;
import com.example.mobileoperator.service.PhoneNumberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientService clientService;
    private PhoneNumberService phoneNumberService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Client> addClient(@RequestBody Client newClient) {

        Client client = new Client();
        client.setFirstName(newClient.getFirstName());
        client.setLastName(newClient.getLastName());
        client.setBirthday(newClient.getBirthday());
        client.setGender(newClient.getGender());
        clientService.add(client);

        List<PhoneNumber> numbers = newClient.getPhoneNumbers();
        for (PhoneNumber number : numbers) {
            client.addPhoneNumber(number);
            phoneNumberService.add(number);
        }
        client = clientService.add(client);
        if (client == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.getAll();
        if (clients == null) {
            return new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getOne(@PathVariable Long id) {
        Optional<Client> client = clientService.getOneById(id);
        if (!client.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(client, HttpStatus.OK);
        }
    }
}
