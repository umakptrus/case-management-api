package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.RfgDto;
import com.example.demo.entity.Rfg;
import com.example.demo.mapper.DisputeMapper;
import com.example.demo.repository.RfgRepository;
import com.example.demo.service.DisputeECPService;

@ExtendWith(MockitoExtension.class)
class DisputeECPServiceTest {

	@InjectMocks
	private DisputeECPService disputeECPService;

	@Mock
	private RfgRepository rfgRepository;

	@Mock
	private DisputeMapper disputeMapper;

	private RfgDto rfgDto;
	private Rfg rfg;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		rfgDto = new RfgDto();
		rfg = new Rfg();
	}

	@Test
	void testCreateEcpCase_whenNewCase() {
		rfgDto.setReturnId("12345");
		rfg.setReturnId("ecp-001");

		when(rfgRepository.existsRfgByReturnId("12345")).thenReturn(false);
		when(disputeMapper.mapDtoToEntity(any())).thenReturn(rfg);
		when(rfgRepository.save(any(Rfg.class))).thenReturn(rfg);

		String result = disputeECPService.createEcpCase(rfgDto);

		assertEquals("ecp-001", result);
		verify(disputeMapper, times(1)).mapDtoToEntity(any());
		verify(rfgRepository, times(1)).save(any());
	}

	@Test
	void testCreateEcpCase_whenReturnIdAlreadyExists() {
		rfgDto.setReturnId("existing-ecp-001");

		when(rfgRepository.existsRfgByReturnId("existing-ecp-001")).thenReturn(true);

		String result = disputeECPService.createEcpCase(rfgDto);

		assertEquals("Case already exists", result);
		verify(rfgRepository, times(1)).existsRfgByReturnId("existing-ecp-001");
		verify(disputeMapper, times(0)).mapDtoToEntity(any());
		verify(rfgRepository, times(0)).save(any());
	}

	@Test
	void testCreateEcpCase_whenReturnIdIsProvidedAndDoesNotExist() {
		rfgDto.setReturnId("new-ecp-001");
		Rfg generatedRfg = new Rfg();
		generatedRfg.setReturnId("new-ecp-001");

		when(rfgRepository.existsRfgByReturnId("new-ecp-001")).thenReturn(false);
		when(disputeMapper.mapDtoToEntity(any())).thenReturn(generatedRfg);
		when(rfgRepository.save(any(Rfg.class))).thenReturn(generatedRfg);

		String result = disputeECPService.createEcpCase(rfgDto);

		assertEquals("new-ecp-001", result);
		verify(rfgRepository, times(1)).existsRfgByReturnId("new-ecp-001");
		verify(disputeMapper, times(1)).mapDtoToEntity(any());
		verify(rfgRepository, times(1)).save(any());
	}

	@Test
	void testCreateEcpCase_whenReturnIdIsEmpty() {
		rfgDto.setReturnId("");
		Rfg generatedRfg = new Rfg();
		generatedRfg.setReturnId("generated-ecp-001");

		when(rfgRepository.existsRfgByReturnId(anyString())).thenReturn(false);
		when(disputeMapper.mapDtoToEntity(any())).thenReturn(generatedRfg);
		when(rfgRepository.save(any(Rfg.class))).thenReturn(generatedRfg);

		String result = disputeECPService.createEcpCase(rfgDto);

		assertEquals("generated-ecp-001", result);
		verify(rfgRepository).existsRfgByReturnId(anyString());
		verify(disputeMapper).mapDtoToEntity(any());
		verify(rfgRepository).save(any());
	}

	@Test
	void testCreateEcpCase_whenReturnIdIsNull() {
		rfgDto.setReturnId(null);
		Rfg generatedRfg = new Rfg();
		generatedRfg.setReturnId("generated-ecp-002");

		when(rfgRepository.existsRfgByReturnId(anyString())).thenReturn(false);
		when(disputeMapper.mapDtoToEntity(any())).thenReturn(generatedRfg);
		when(rfgRepository.save(any(Rfg.class))).thenReturn(generatedRfg);

		String result = disputeECPService.createEcpCase(rfgDto);

		assertEquals("generated-ecp-002", result);
		verify(rfgRepository).existsRfgByReturnId(anyString());
		verify(disputeMapper).mapDtoToEntity(any());
		verify(rfgRepository).save(any());
	}

	@Test
	void testCreateEcpCase_whenSaveReturnsNull() {
		rfgDto.setReturnId("valid-ecp-002");
		Rfg mappedRfg = new Rfg();
		mappedRfg.setReturnId("valid-ecp-002");

		when(rfgRepository.existsRfgByReturnId("valid-ecp-002")).thenReturn(false);
		when(disputeMapper.mapDtoToEntity(any())).thenReturn(mappedRfg);
		when(rfgRepository.save(any(Rfg.class))).thenReturn(null);

		RuntimeException exception = null;
		try {
			disputeECPService.createEcpCase(rfgDto);
		} catch (RuntimeException e) {
			exception = e;
		}

		assertTrue(exception.getMessage().contains("Cannot invoke "));
		verify(rfgRepository).existsRfgByReturnId("valid-ecp-002");
		verify(disputeMapper).mapDtoToEntity(any());
		verify(rfgRepository).save(any());
	}
}