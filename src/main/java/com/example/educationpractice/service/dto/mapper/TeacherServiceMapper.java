package com.example.educationpractice.service.dto.mapper;

import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherServiceMapper {

    TeacherServiceMapper INSTANCE = Mappers.getMapper(TeacherServiceMapper.class);

    TeacherServiceDto toServiceDto(TeacherEntity entity);

    TeacherEntity toTeacherEntity(TeacherServiceDto dto);


   List<TeacherServiceDto> toServiceDtoList(List<TeacherEntity> entity);











}
