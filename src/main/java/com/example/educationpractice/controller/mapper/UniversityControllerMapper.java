package com.example.educationpractice.controller.mapper;

import com.example.educationpractice.controller.dto.response.UniversityResponseDto;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UniversityControllerMapper {


    UniversityResponseDto toResponseUniversityDto(UniversityServiceDto serviceDto);

    List<UniversityResponseDto> toResponseUniversityDtoList(List<UniversityServiceDto> serviceDto);
}
