package com.example.mobileoperator.service;

import com.example.mobileoperator.model.Call;
import com.example.mobileoperator.repository.CallRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Data
@AllArgsConstructor
public class CallService {

    private CallRepository repository;

    public Call add(Call call) {
        return repository.save(call);
    }

    public List<Call> getAll() {
        return repository.findAll();
    }

    public Map<String, Long> getCallPerEachCity() {
        List<Object[]> list = repository.countByCity();
        Map<String, Long> map = new HashMap<>();
        for (Object[] obj : list) {
            map.put((String) obj[0], (Long) obj[1]);
        }

        return map;
    }

    public Call getLongestBetweenDates(Long id, LocalDate from, LocalDate to) {
        return repository.findByCallDateBetween(id, from, to);
    }
}
