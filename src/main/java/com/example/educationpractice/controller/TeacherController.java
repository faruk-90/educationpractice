package com.example.educationpractice.controller;

import com.example.educationpractice.controller.dto.request.TeacherRequestDto;
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.controller.dto.response.TeacherResponseDto;
import com.example.educationpractice.controller.mapper.StudentControllerMapper;
import com.example.educationpractice.controller.mapper.TeacherControllerMapper;
import com.example.educationpractice.controller.mapper.UniversityControllerMapper;
import com.example.educationpractice.repository.StudentRepository;
import com.example.educationpractice.service.StudentService;
import com.example.educationpractice.service.TeacherService;
import com.example.educationpractice.service.UniversityService;
import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/teachers")
@AllArgsConstructor
@Data
public class TeacherController {

    private final UniversityService universityService;
    private final TeacherService teacherService;
    private final UniversityControllerMapper universityControllerMapper;
    private final TeacherControllerMapper teacherControllerMapper;

    private final StudentService studentService;
    private final StudentControllerMapper studentControllerMapper;
    private  final StudentRepository studentRepository;



    @GetMapping
    public CommonResponDto<List<TeacherResponseDto>> getTeachers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) BigDecimal salary,
            @RequestParam(required = false) Integer universityId) {

        List<TeacherServiceDto> teacherServiceDtoList =
                teacherService.getTeachers(name, surname, age, salary, universityId);

        return new CommonResponDto<>(
                teacherControllerMapper.toTeacherResponseDtoList(teacherServiceDtoList)
        );
    }
    @PostMapping
    public CommonResponDto<TeacherResponseDto> insert(
            @RequestBody TeacherRequestDto teacherRequestDto) {
        TeacherServiceDto teacherServiceDto =
                teacherControllerMapper.toTeacherServiceDto(teacherRequestDto);
        teacherService.create(teacherServiceDto);
        return new CommonResponDto<>(
                teacherControllerMapper.toTeacherResponseDto(teacherServiceDto)
        );
    }

    @GetMapping("/{id}/students")
    public CommonResponDto<List<StudentResponseDto>> getTeacherStudents(
            @PathVariable Integer id) {

        List<StudentServiceDto> students =
                studentService.getStudentsByTeacher(id);

        return new CommonResponDto<>(
                studentControllerMapper.toResponseDtoList(students)
        );
    }

    @PutMapping("{id}")
    public CommonResponDto<TeacherResponseDto> update(
            @PathVariable Integer id, @RequestBody TeacherRequestDto teacherRequestDto) {

        TeacherServiceDto teacherServiceDto =
                teacherControllerMapper.toTeacherServiceDto(teacherRequestDto);
        teacherServiceDto.setId(id);
        TeacherServiceDto serviceDto = teacherService.create(teacherServiceDto);
        return new CommonResponDto<>(
                teacherControllerMapper.toTeacherResponseDto(serviceDto)
        );
    }

    @DeleteMapping("/{id}")
    public CommonResponDto<TeacherResponseDto> delete(@PathVariable Integer id) {
        teacherService.deleteById(id);
        return new CommonResponDto<>(new TeacherResponseDto(id),
                "Teacher deleted successfully", 200);
    }

//    @GetMapping("/students/{studentId}/teachers")
//    public CommonResponDto<List<TeacherResponseDto>> getTeachersByStudent(@PathVariable Integer studentId) {
//        List<TeacherServiceDto> teachers = teacherService.getTeachersByStudent(studentId);
//        List<TeacherResponseDto> dtoList = teacherControllerMapper.toTeacherResponseDtoList(teachers);
//        return new CommonResponDto<>(dtoList, "Students fetched", 200);
//    }
@DeleteMapping("/{teacherId}/students/{studentId}")
public CommonResponDto<Void> removeStudentFromTeacher(
        @PathVariable Integer teacherId,
        @PathVariable Integer studentId) {

    teacherService.removeStudent(teacherId, studentId);

    return new CommonResponDto<>(
            null,
            "Student removed from teacher",
            200
    );
}
@PostMapping("/{teacherId}/students/{studentId}")
public CommonResponDto<Void> addStudentToTeacher(
        @PathVariable Integer teacherId,
        @PathVariable Integer studentId) {
    teacherService.addStudent(teacherId, studentId);
    return new CommonResponDto<>(
            null,
            "Student added to teacher",
            200
    );
        }
}
