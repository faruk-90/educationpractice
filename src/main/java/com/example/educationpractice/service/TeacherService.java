package com.example.educationpractice.service;

import com.example.educationpractice.repository.StudentRepository;
import com.example.educationpractice.repository.TeacherRepository;
import com.example.educationpractice.repository.TeacherStudentRepository;
import com.example.educationpractice.repository.entity.StudentEntity;
import com.example.educationpractice.repository.entity.TeacherEntity;
import com.example.educationpractice.repository.specification.TeacherSpecification;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import com.example.educationpractice.service.dto.mapper.TeacherServiceMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public TeacherService(TeacherRepository teacherRepository,
                          StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public List<TeacherServiceDto> getTeachers(String name,
                                               String surname,
                                               Integer age,
                                               BigDecimal salary,
                                               Integer universityId) {

        Specification<TeacherEntity> filter =
                TeacherSpecification.filter(name, surname, age, salary, universityId);

        return TeacherServiceMapper.INSTANCE
                .toServiceDtoList(teacherRepository.findAll(filter));
    }

    public TeacherServiceDto create(TeacherServiceDto dto) {
        TeacherEntity entity = TeacherServiceMapper.INSTANCE.toTeacherEntity(dto);
        teacherRepository.save(entity);
        return TeacherServiceMapper.INSTANCE.toServiceDto(entity);
    }

    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    public TeacherServiceDto getById(Integer id) {
        return TeacherServiceMapper.INSTANCE
                .toServiceDto(teacherRepository.findById(id).orElseThrow());
    }

    public List<TeacherServiceDto> getTeachersByStudent(Integer studentId) {
        return teacherRepository.findTeachersByStudentId(studentId)
                .stream()
                .map(TeacherServiceMapper.INSTANCE::toServiceDto)
                .toList();
    }

    public void removeStudent(Integer teacherId, Integer studentId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow();
        StudentEntity student = studentRepository.findById(studentId).orElseThrow();

        teacher.getStudents().remove(student);
        student.getTeachers().remove(teacher);
    }
    public void addStudent(Integer teacherId, Integer studentId) {
        TeacherEntity teacher = teacherRepository.findById(teacherId).orElseThrow();
        StudentEntity student = studentRepository.findById(studentId).orElseThrow();
        teacher.getStudents().add(student);
        student.getTeachers().add(teacher);
    }
}
