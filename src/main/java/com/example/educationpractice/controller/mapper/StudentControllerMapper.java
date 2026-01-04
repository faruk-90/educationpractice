package com.example.educationpractice.controller.mapper;

import com.example.educationpractice.controller.dto.request.StudentRequestDto;
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.service.dto.StudentServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentControllerMapper {



    StudentResponseDto toResponseDto(StudentServiceDto serviceDto);

    List<StudentResponseDto> toResponseDtoList(List<StudentServiceDto> serviceDto);

    StudentServiceDto toStudentSercviceDto(StudentRequestDto serviceDto);

    StudentRequestDto toStudentRequestDto(StudentServiceDto studentDto);

}
