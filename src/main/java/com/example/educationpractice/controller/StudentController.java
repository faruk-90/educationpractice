package com.example.educationpractice.controller;

import com.example.educationpractice.controller.CommonResponDto;
import com.example.educationpractice.controller.dto.request.StudentRequestDto;
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.controller.mapper.StudentControllerMapper;
import com.example.educationpractice.service.StudentService;
import com.example.educationpractice.service.dto.StudentServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentControllerMapper studentControllerMapper;

    @GetMapping
    public CommonResponDto<List<StudentResponseDto>> getStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) BigDecimal scholarship,
            @RequestParam(required = false) Integer universityId) {

        List<StudentServiceDto> list =
                studentService.getStudents(name, surname, age, scholarship, universityId);

        return new CommonResponDto<>(studentControllerMapper.toResponseDtoList(list));
    }

    @GetMapping("/{id}")
    public CommonResponDto<StudentResponseDto> getStudentById(@PathVariable Integer id) {
        StudentServiceDto dto = studentService.getStudentById(id);
        return new CommonResponDto<>(studentControllerMapper.toResponseDto(dto));
    }

    @PostMapping
    public CommonResponDto<StudentResponseDto> insert(@RequestBody StudentRequestDto requestDto) {
        StudentServiceDto dto = studentControllerMapper.toStudentSercviceDto(requestDto);
        studentService.create(dto);
        return new CommonResponDto<>(studentControllerMapper.toResponseDto(dto));
    }

    @PutMapping("/{id}")
    public CommonResponDto<StudentResponseDto> update(
            @PathVariable Integer id,
            @RequestBody StudentRequestDto requestDto) {

        StudentServiceDto dto = studentControllerMapper.toStudentSercviceDto(requestDto);
        dto.setId(id);
        StudentServiceDto updated = studentService.create(dto);

        return new CommonResponDto<>(
                studentControllerMapper.toResponseDto(updated),
                "Student updated successfully",
                200
        );
    }

    @DeleteMapping("/{id}")
    public CommonResponDto<?> delete(@PathVariable Integer id) {
        studentService.deleteById(id);
        return new CommonResponDto<>(null, "Student deleted successfully", 200);
    }

    @GetMapping("/by-teacher/{teacherId}")
    public CommonResponDto<List<StudentResponseDto>> getStudentsByTeacher(
            @PathVariable Integer teacherId) {

        List<StudentServiceDto> students =
                studentService.getStudentsByTeacher(teacherId);

        return new CommonResponDto<>(
                studentControllerMapper.toResponseDtoList(students),
                "Students fetched",
                200
        );
    }
}
