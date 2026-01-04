package com.example.educationpractice.service.dto.mapper;

import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentServiceMapper {

    StudentServiceMapper INSTANCE = Mappers.getMapper(StudentServiceMapper.class);

    StudentServiceDto toServiceDto(StudentEntity entity);

    StudentEntity toEntity(StudentServiceDto serviceDto);

    List<StudentServiceDto> toServiceDtoList(List<StudentEntity> entity);



}
