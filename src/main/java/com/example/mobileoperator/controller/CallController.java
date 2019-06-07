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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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
        if (calls == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(calls, HttpStatus.OK);
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public ResponseEntity getCallsByCityName() {
        Map<String, Long> callsByCities = callService.getCallPerEachCity();
        if (callsByCities == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(callsByCities, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/{startDate}/{endDate}", method = RequestMethod.GET)
    public ResponseEntity<Call> getLongestBetweenDates(@PathVariable Long id, @PathVariable String startDate,
                                                       @PathVariable String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate from = LocalDate.parse(startDate, formatter);
        LocalDate to = LocalDate.parse(endDate, formatter);
        Call call = callService.getLongestBetweenDates(id, from, to);

        return new ResponseEntity<>(call, HttpStatus.OK);
    }
}