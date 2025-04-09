package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.RfgDto;
import com.example.demo.entity.Rfg;

@Mapper(componentModel = "spring")
public interface DisputeMapper {

	/**
	 * Maps an RfgDto to an Rfg entity.
	 *
	 * @param rfgDto the source DTO object
	 * @return the mapped entity object
	 */
	DisputeMapper mapper = Mappers.getMapper(DisputeMapper.class);

	Rfg mapDtoToEntity(RfgDto rfgDto);
}
