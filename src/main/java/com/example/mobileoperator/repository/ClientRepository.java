package com.example.mobileoperator.repository;

import com.example.mobileoperator.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPhoneNumbersEquals(String phoneNumber);
}
