package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rfg")
@Data
public class Rfg {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "return_id", length = 100, nullable = false, updatable = false)
    private String returnId;

    @Column(name = "payment_request_id")
    private String paymentRequestId;

    @Column(name = "capture_id")
    private String captureId;

    @Column(name = "refund_cptr_id")
    private String refundCptrId;

    @Column(name = "auth_id")
    private String authId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "amount_multivalued")
    private String amountMultivalued;

    @Column(name = "reason_code")
    private String reasonCode;

    @Column(name = "reason_description")
    private String reasonDescription;

    @Column(name = "credit_debit_type_code")
    private String creditDebitTypeCode;

    @Column(name = "action_name")
    private String actionName;

    @Column(name = "return_capture_timestamp")
    private LocalDateTime returnCaptureTimestamp;

    @Column(name = "transaction_processing_entity_id")
    private Long transactionProcessingEntityId;

    @Column(name = "transaction_timestamp")
    private LocalDateTime transactionTimestamp;

    @Column(name = "retry_attempt_number")
    private Integer retryAttemptNumber;

    @Column(name = "payment_method_code")
    private String paymentMethodCode;

    @Column(name = "payment_method_name")
    private String paymentMethodName;

    @Column(name = "payment_transaction_type_code")
    private String paymentTransactionTypeCode;
}