package com.example.educationpractice.service.dto.mapper;

import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherServiceMapper {

    TeacherServiceMapper INSTANCE = Mappers.getMapper(TeacherServiceMapper.class);

    TeacherEntity toTeacherEntity(TeacherServiceDto dto);

    TeacherServiceDto toTeacherServiceDto(TeacherEntity teacherEntity);

    List<TeacherServiceDto> toTeacherServiceDtoList(List<TeacherEntity> teacherEntity);











}
