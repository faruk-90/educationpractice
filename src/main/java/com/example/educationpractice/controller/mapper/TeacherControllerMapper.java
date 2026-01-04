package com.example.educationpractice.controller.mapper;

import com.example.educationpractice.controller.dto.request.StudentRequestDto;
import com.example.educationpractice.controller.dto.request.TeacherRequestDto;
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.controller.dto.response.TeacherResponseDto;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherControllerMapper {


   TeacherResponseDto toTeacherResponseDto(TeacherServiceDto serviceDto);

    List<TeacherResponseDto> toTeacherResponseDtoList(List<TeacherServiceDto> serviceDto);

    TeacherServiceDto toTeacherServiceDto(TeacherRequestDto serviceDto);


    TeacherRequestDto toTeacherRequestDto(TeacherServiceDto teacherDto);
}
