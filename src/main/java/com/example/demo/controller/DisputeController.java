package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RfgDto;
import com.example.demo.service.DisputeECPService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/ecp-case")
@RequiredArgsConstructor
public class DisputeController {

	@Autowired
    private DisputeECPService disputeECPService;

    @PostMapping("/create")
    public String createEcpCase(@RequestBody RfgDto request) {
        String id = disputeECPService.createEcpCase(request);
        if ("Case already exists".equalsIgnoreCase(id)) {
            return "ECP Case already exists: " + request.getReturnId();
        }
        return "ECP case created successfully with Id: " + id;
    }

    @PostMapping("/update")
    public String updateEcpCase() {
        // TODO: Add update logic
        return "ECP case updated successfully";
    }

}