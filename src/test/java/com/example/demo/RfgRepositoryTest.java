package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Rfg;
import com.example.demo.repository.RfgRepository;

@ExtendWith(MockitoExtension.class)
class RfgRepositoryTest {

	@Mock
	private RfgRepository rfgRepository;

	private static final String EXISTING_RETURN_ID = "12345";
	private static final String NON_EXISTING_RETURN_ID = "67890";

	@BeforeEach
	void setUp() {
		createMockRfg(EXISTING_RETURN_ID);
	}

	@Test
	void shouldReturnTrue_WhenRfgExistsByReturnId() {
		when(rfgRepository.existsRfgByReturnId(EXISTING_RETURN_ID)).thenReturn(true);

		boolean exists = rfgRepository.existsRfgByReturnId(EXISTING_RETURN_ID);

		assertTrue(exists);
		verify(rfgRepository).existsRfgByReturnId(EXISTING_RETURN_ID);
	}

	@Test
	void shouldReturnFalse_WhenRfgDoesNotExistByReturnId() {
		when(rfgRepository.existsRfgByReturnId(NON_EXISTING_RETURN_ID)).thenReturn(false);

		boolean exists = rfgRepository.existsRfgByReturnId(NON_EXISTING_RETURN_ID);

		assertFalse(exists);
		verify(rfgRepository).existsRfgByReturnId(NON_EXISTING_RETURN_ID);
	}

	// Helper method to create a mock Rfg object
	private Rfg createMockRfg(String returnId) {
		Rfg rfg = new Rfg();
		rfg.setReturnId(returnId);
		rfg.setPaymentRequestId("abc123");
		rfg.setCaptureId("cap123");
		rfg.setRefundCptrId("refund123");
		rfg.setAuthId("auth123");
		rfg.setTransactionId("txn123");
		rfg.setAmountMultivalued("100.00");
		rfg.setReasonCode("RC123");
		rfg.setReasonDescription("Payment refund");
		rfg.setCreditDebitTypeCode("CREDIT");
		rfg.setActionName("Refund");
		rfg.setTransactionProcessingEntityId(987654L);
		rfg.setRetryAttemptNumber(1);
		rfg.setPaymentMethodCode("VISA");
		rfg.setPaymentMethodName("Visa Credit Card");
		rfg.setPaymentTransactionTypeCode("AUTH");
		return rfg;
	}
}