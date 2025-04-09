package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RfgDto {
	private String returnId;
	private String paymentRequestId;
	private String captureId;
	private String refundCptrId;
	private String authId;
	private String transactionId;
	private String amountMultivalued;
	private String reasonCode;
	private String reasonDescription;
	private String creditDebitTypeCode;
	private String actionName;
	private LocalDateTime returnCaptureTimestamp;
	private Long transactionProcessingEntityId;
	private LocalDateTime transactionTimestamp;
	private Integer retryAttemptNumber;
	private String paymentMethodCode;
	private String paymentMethodName;
	private String paymentTransactionTypeCode;

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getPaymentRequestId() {
		return paymentRequestId;
	}

	public void setPaymentRequestId(String paymentRequestId) {
		this.paymentRequestId = paymentRequestId;
	}

	public String getCaptureId() {
		return captureId;
	}

	public void setCaptureId(String captureId) {
		this.captureId = captureId;
	}

	public String getRefundCptrId() {
		return refundCptrId;
	}

	public void setRefundCptrId(String refundCptrId) {
		this.refundCptrId = refundCptrId;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAmountMultivalued() {
		return amountMultivalued;
	}

	public void setAmountMultivalued(String amountMultivalued) {
		this.amountMultivalued = amountMultivalued;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonDescription() {
		return reasonDescription;
	}

	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}

	public String getCreditDebitTypeCode() {
		return creditDebitTypeCode;
	}

	public void setCreditDebitTypeCode(String creditDebitTypeCode) {
		this.creditDebitTypeCode = creditDebitTypeCode;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public LocalDateTime getReturnCaptureTimestamp() {
		return returnCaptureTimestamp;
	}

	public void setReturnCaptureTimestamp(LocalDateTime returnCaptureTimestamp) {
		this.returnCaptureTimestamp = returnCaptureTimestamp;
	}

	public Long getTransactionProcessingEntityId() {
		return transactionProcessingEntityId;
	}

	public void setTransactionProcessingEntityId(Long transactionProcessingEntityId) {
		this.transactionProcessingEntityId = transactionProcessingEntityId;
	}

	public LocalDateTime getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(LocalDateTime transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public Integer getRetryAttemptNumber() {
		return retryAttemptNumber;
	}

	public void setRetryAttemptNumber(Integer retryAttemptNumber) {
		this.retryAttemptNumber = retryAttemptNumber;
	}

	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}

	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getPaymentTransactionTypeCode() {
		return paymentTransactionTypeCode;
	}

	public void setPaymentTransactionTypeCode(String paymentTransactionTypeCode) {
		this.paymentTransactionTypeCode = paymentTransactionTypeCode;
	}

}
