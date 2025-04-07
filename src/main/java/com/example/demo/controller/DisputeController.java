package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CaseRequestDTO;
import com.example.demo.service.DisputeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cases")
@RequiredArgsConstructor
public class DisputeController {

    private final DisputeService service;

    @PostMapping("/CreateCase")
    public ResponseEntity<?> createCase(@RequestBody CaseRequestDTO request) {
        try {
            // Check for duplicate case only if returnId is provided
            if (request.getReturnId() != null && service.isDuplicate(request.getReturnId())) {
                return ResponseEntity.badRequest().body("Case with return_id already exists.");
            }

            // Create the case
            return ResponseEntity.ok(service.createCase(request));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Unexpected error: " + e.getMessage());
        }
    }
}