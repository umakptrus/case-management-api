package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Dispute;

public interface DisputeRepository extends JpaRepository<Dispute, String> {
    boolean existsByReturnId(String returnId);
}
