package com.example.mobileoperator.repository;

import com.example.mobileoperator.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CallRepository extends JpaRepository<Call, Long> {


    @Query("SELECT c.city, count(c.city) from Call c group by c.city")
    List<Object[]> countByCity();


    @Query("select c from Call c where c.duration = max(c.duration) and c.clientId = ?1 and c.callDate between ?2 and ?3")
    Call findByCallDateBetween(Long id, LocalDate from, LocalDate to);
}