package com.example.mobileoperator.service;

import com.example.mobileoperator.model.PhoneNumber;
import com.example.mobileoperator.repository.PhoneNumberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
@AllArgsConstructor
public class PhoneNumberService {

    private PhoneNumberRepository repository;

    public PhoneNumber add(PhoneNumber phoneNumber) {
        return repository.save(phoneNumber);
    }
}
