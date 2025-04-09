package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RfgDto;
import com.example.demo.entity.Rfg;
import com.example.demo.mapper.DisputeMapper;
import com.example.demo.repository.RfgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisputeECPService {

	@Autowired
	private RfgRepository rfgRepository;
	@Autowired
	private DisputeMapper disputeMapper;

	public String createEcpCase(RfgDto request) {
		// Generate a new returnId if it's null or empty
		if (request.getReturnId() == null || request.getReturnId().isEmpty()) {
			request.setReturnId(UUID.randomUUID().toString());
		}

		// Check if the returnId already exists
		if (rfgRepository.existsRfgByReturnId(request.getReturnId())) {
			return "Case already exists";
		}

		// Use the injected disputeMapper instance
		Rfg rfg = disputeMapper.mapDtoToEntity(request);
		Rfg savedRfg = rfgRepository.save(rfg);

		// Return the saved returnId
		return savedRfg.getReturnId();
	}
}