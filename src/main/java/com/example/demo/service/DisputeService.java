package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CaseRequestDTO;
import com.example.demo.entity.Dispute;
import com.example.demo.repository.DisputeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisputeService {

    private final DisputeRepository repository;

    public boolean isDuplicate(String returnId) {
        return repository.existsByReturnId(returnId);
    }

    @Transactional
    public Dispute createCase(CaseRequestDTO dto) {
        Dispute dispute = mapToEntity(dto);
        return repository.save(dispute);
    }

    private Dispute mapToEntity(CaseRequestDTO dto) {
        Dispute dispute = new Dispute();
        dispute.setReturnId(dto.getReturnId());
        dispute.setPaymentRequestId(dto.getPaymentRequestId());
        dispute.setCaptureId(dto.getCaptureId());
        dispute.setRefundCptrId(dto.getRefundCptrId());
        dispute.setAuthId(dto.getAuthId());
        dispute.setTransactionId(dto.getTransactionId());
        dispute.setAmountMultivalued(dto.getAmountMultivalued());
        dispute.setReasonCode(dto.getReasonCode());
        dispute.setReasonDescription(dto.getReasonDescription());
        dispute.setCreditDebitTypeCode(dto.getCreditDebitTypeCode());
        dispute.setActionName(dto.getActionName());
        dispute.setReturnCaptureTimestamp(dto.getReturnCaptureTimestamp());
        dispute.setTransactionProcessingEntityId(dto.getTransactionProcessingEntityId());
        dispute.setTransactionTimestamp(dto.getTransactionTimestamp());
        dispute.setRetryAttemptNumber(dto.getRetryAttemptNumber());
        dispute.setPaymentMethodCode(dto.getPaymentMethodCode());
        dispute.setPaymentMethodName(dto.getPaymentMethodName());
        dispute.setPaymentTransactionTypeCode(dto.getPaymentTransactionTypeCode());
        return dispute;
    }
}