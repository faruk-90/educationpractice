package com.example.educationpractice.controller;
import com.example.educationpractice.controller.dto.request.StudentRequestDto;
import com.example.educationpractice.controller.dto.response.StudentResponseDto;
import com.example.educationpractice.controller.mapper.StudentControllerMapper;
import com.example.educationpractice.service.StudentService;
import com.example.educationpractice.service.dto.StudentServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
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
        StudentServiceDto studentServiceDto = studentService.getStudentById(id);
        return new CommonResponDto<>(studentControllerMapper.toResponseDto(studentServiceDto));
    }


    @PostMapping
    public CommonResponDto<StudentResponseDto> insert(@RequestBody StudentRequestDto requestDto) {
        StudentServiceDto studentServiceDto = studentControllerMapper.toStudentSercviceDto(requestDto);
        studentService.create(studentServiceDto);
        return new CommonResponDto<>(studentControllerMapper.toResponseDto(studentServiceDto));
    }


    @DeleteMapping("/{id}")
    public CommonResponDto<StudentResponseDto> delete(@PathVariable Integer id) {
        studentService.deleteById(id);
        return new CommonResponDto<>(new StudentResponseDto(id),
                "Student deleted successfully", 200);
    }


    @PutMapping("/{id}")
    public CommonResponDto<StudentResponseDto> update(@PathVariable Integer id, @RequestBody StudentRequestDto requestDto) {
        StudentServiceDto studentServiceDto = studentControllerMapper.toStudentSercviceDto(requestDto);
        studentServiceDto.setId(id);
        StudentServiceDto serviceDto = studentService.create(studentServiceDto);

        return new CommonResponDto<>(studentControllerMapper.toResponseDto(serviceDto),
                "updated Student updated successfully",
                200);
    }

}



