package com.example.educationpractice.service;

import com.example.educationpractice.repository.TeacherRepository;
import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.repository.specification.TeacherSpecification;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import com.example.educationpractice.service.dto.mapper.TeacherServiceMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherServiceDto> getTeachers(String name,
                                               String surname,
                                               Integer age,
                                               BigDecimal salary,
                                               Integer universityId) {
        Specification<TeacherEntity> filter = TeacherSpecification.filter(name, surname, age, salary, universityId);
        List<TeacherEntity> list = teacherRepository.findAll(filter);

        return TeacherServiceMapper.INSTANCE.toTeacherServiceDtoList(list);

    }

    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    public void create(TeacherServiceDto teacherServiceDto) {
        TeacherEntity teacherEntity = TeacherServiceMapper.INSTANCE.toTeacherEntity(teacherServiceDto);
        teacherRepository.save(teacherEntity);
    }


    public void update(TeacherServiceDto teacherServiceDto) {
        TeacherEntity teacherEntity = TeacherServiceMapper.INSTANCE.toTeacherEntity(teacherServiceDto);
        teacherRepository.save(teacherEntity);
    }

    public TeacherServiceDto getById(Integer id) {

        TeacherEntity teacherEntity = teacherRepository.findById(id).orElseThrow();
        return TeacherServiceMapper.INSTANCE.toTeacherServiceDto(teacherEntity);
    }
}
