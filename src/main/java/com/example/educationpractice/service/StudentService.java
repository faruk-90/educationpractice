package com.example.educationpractice.service;

import com.example.educationpractice.repository.StudentRepository;
import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.specification.StudentSpecification;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.mapper.StudentServiceMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentServiceDto> getStudents(String name,
                                               String surname,
                                               Integer age,
                                               BigDecimal scholarship,
                                               Integer universityId) {

        Specification<StudentEntity> filter =
                StudentSpecification.filter(name, surname, age, scholarship, universityId);

        List<StudentEntity> list = studentRepository.findAll(filter);

        return StudentServiceMapper.INSTANCE.toServiceDtoList(list);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public StudentServiceDto create(StudentServiceDto studentServiceDto) {
        StudentEntity studentEntity =
                StudentServiceMapper.INSTANCE.toEntity(studentServiceDto);

        studentRepository.save(studentEntity);

        return StudentServiceMapper.INSTANCE.toServiceDto(studentEntity);
    }

    public StudentServiceDto update(StudentServiceDto studentServiceDto) {
        StudentEntity studentEntity =
                StudentServiceMapper.INSTANCE.toEntity(studentServiceDto);

        studentRepository.save(studentEntity);

        return StudentServiceMapper.INSTANCE.toServiceDto(studentEntity);
    }

    public StudentServiceDto getStudentById(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return StudentServiceMapper.INSTANCE.toServiceDto(studentEntity);
    }


    public List<StudentServiceDto> getByTeacherId(Integer teacherId) {
        return studentRepository.findByTeacher_Id(teacherId)
                .stream()
                .map(StudentServiceMapper.INSTANCE::toServiceDto)
                .toList();
    }
}
