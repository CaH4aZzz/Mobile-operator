package com.example.mobileoperator.service;

import com.example.mobileoperator.model.Call;
import com.example.mobileoperator.repository.CallRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
@AllArgsConstructor
public class CallService {

    private CallRepository repository;

    public Call add(Call call) {
        return repository.save(call);
    }
}
