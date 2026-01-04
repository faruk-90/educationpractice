package com.example.educationpractice.controller;

import com.example.educationpractice.controller.CommonResponDto;
<<<<<<< HEAD
import com.example.educationpractice.controller.dto.request.TeacherRequestDto;
=======
>>>>>>> 62ed5898ea75fde1e615b69652cf52f6536eea42
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.controller.dto.response.TeacherResponseDto;
import com.example.educationpractice.controller.mapper.StudentControllerMapper;
import com.example.educationpractice.controller.mapper.TeacherControllerMapper;
import com.example.educationpractice.controller.mapper.UniversityControllerMapper;
import com.example.educationpractice.repository.StudentRepository;
import com.example.educationpractice.repository.entity.StudentEntity;
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
<<<<<<< HEAD
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
=======
>>>>>>> 62ed5898ea75fde1e615b69652cf52f6536eea42

    @GetMapping("/{id}/students")
    public CommonResponDto<List<StudentResponseDto>> getTeacherStudents(
            @PathVariable Integer id) {

        List<StudentServiceDto> students =
                studentService.getByTeacherId(id);

        return new CommonResponDto<>(
                studentControllerMapper.toResponseDtoList(students)
        );
    }
<<<<<<< HEAD

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
=======
>>>>>>> 62ed5898ea75fde1e615b69652cf52f6536eea42
}
