package com.example.mobileoperator.repository;

import com.example.mobileoperator.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Long> {
}
