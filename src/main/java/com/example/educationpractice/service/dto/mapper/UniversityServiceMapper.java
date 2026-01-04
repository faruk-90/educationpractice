package com.example.educationpractice.service.dto.mapper;

import com.example.educationpractice.repository.entity.UniversityEntity;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversityServiceMapper {

    UniversityServiceMapper INSTANCE = Mappers.getMapper(UniversityServiceMapper.class);

    UniversityServiceDto toServiceDto(UniversityEntity entity);

    List<UniversityServiceDto> toServiceDtoList(List<UniversityEntity> entity);

}
