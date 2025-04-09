package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rfg;

@Repository
public interface RfgRepository extends JpaRepository<Rfg, Long> {
    boolean existsRfgByReturnId(String returnId);
}

