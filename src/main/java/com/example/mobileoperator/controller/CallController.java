package com.example.mobileoperator.controller;

import com.example.mobileoperator.model.Call;
import com.example.mobileoperator.service.CallService;
import com.example.mobileoperator.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping(value = "/calls", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CallController {

    private CallService callService;
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Call> addCall(@RequestBody Call inCall) {
        Call call = callService.add(inCall);

        if (call == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(call, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Call>> getAllCalls() {
        List<Call> calls = callService.getAll();
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }
}