package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.DisputeController;
import com.example.demo.dto.RfgDto;
import com.example.demo.service.DisputeECPService;

@ExtendWith(MockitoExtension.class)
class DisputeControllerTest {

	private static final String CASE_ALREADY_EXISTS = "Case already exists";
	private static final String CASE_ALREADY_EXISTS_UPPER = "CASE ALREADY EXISTS";
	private static final String CASE_CREATED_SUCCESSFULLY = "ecp-001";
	private static final String RETURN_ID = "12345";
	private static final String CASE_ALREADY_EXISTS_MESSAGE = "ECP Case already exists: ";
	private static final String CASE_CREATED_SUCCESS_MESSAGE = "ECP case created successfully with Id: ";
	private static final String CASE_UPDATED_SUCCESS_MESSAGE = "ECP case updated successfully";

	@Mock
	private DisputeECPService disputeECPService;

	@InjectMocks
	private DisputeController disputeController;

	private RfgDto request;

	@BeforeEach
	void setUp() {
		request = new RfgDto();
		request.setReturnId(RETURN_ID);
		request.setPaymentRequestId("P456");
		request.setCaptureId("C789");
		request.setRefundCptrId("RC101");
		request.setAuthId("A202");
		request.setTransactionId("T303");
		request.setAmountMultivalued("100.50");
		request.setReasonCode("RC01");
		request.setReasonDescription("Test Reason");
		request.setCreditDebitTypeCode("CD01");
		request.setActionName("Refund");
		request.setPaymentMethodCode("PM01");
		request.setPaymentMethodName("Credit Card");
		request.setPaymentTransactionTypeCode("PT01");
	}

	@Test
	void testCreateEcpCase_whenCaseAlreadyExists_caseInsensitiveMatch() {
		mockDisputeServiceResponse(CASE_ALREADY_EXISTS_UPPER);
		String result = disputeController.createEcpCase(request);
		assertEquals(CASE_ALREADY_EXISTS_MESSAGE + RETURN_ID, result);
		verifyDisputeServiceCall();
	}

	@Test
	void testCreateEcpCase_whenCaseAlreadyExists_exactMatch() {
		mockDisputeServiceResponse(CASE_ALREADY_EXISTS);
		String result = disputeController.createEcpCase(request);
		assertEquals(CASE_ALREADY_EXISTS_MESSAGE + RETURN_ID, result);
		verifyDisputeServiceCall();
	}

	@Test
	void testCreateEcpCase_whenCaseCreatedSuccessfully() {
		mockDisputeServiceResponse(CASE_CREATED_SUCCESSFULLY);
		String result = disputeController.createEcpCase(request);
		assertEquals(CASE_CREATED_SUCCESS_MESSAGE + CASE_CREATED_SUCCESSFULLY, result);
		verifyDisputeServiceCall();
	}

	@Test
	void testCreateEcpCase_whenReturnIdIsNull() {
		request.setReturnId(null);
		mockDisputeServiceResponse(CASE_ALREADY_EXISTS);
		String result = disputeController.createEcpCase(request);
		assertEquals(CASE_ALREADY_EXISTS_MESSAGE + "null", result);
		verifyDisputeServiceCall();
	}

	@Test
	void testCreateEcpCase_whenServiceThrowsException() {
		when(disputeECPService.createEcpCase(request)).thenThrow(new RuntimeException("Service error"));
		try {
			disputeController.createEcpCase(request);
		} catch (RuntimeException e) {
			assertEquals("Service error", e.getMessage());
		}
	}

	@Test
	void testUpdateEcpCase_alwaysReturnsSuccess() {
		String result = disputeController.updateEcpCase();
		assertEquals(CASE_UPDATED_SUCCESS_MESSAGE, result);
	}

	private void mockDisputeServiceResponse(String response) {
		when(disputeECPService.createEcpCase(request)).thenReturn(response);
	}

	private void verifyDisputeServiceCall() {
		verify(disputeECPService, times(1)).createEcpCase(request);
	}
}