package com.example.educationpractice.service.dto;

import com.example.educationpractice.service.dto.UniversityServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherServiceDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private UniversityServiceDto university;

    // əlaqə YOXDUR
}
