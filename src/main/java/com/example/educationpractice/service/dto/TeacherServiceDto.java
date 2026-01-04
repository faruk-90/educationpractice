package com.example.educationpractice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherServiceDto {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private UniversityServiceDto university;
    private StudentServiceDto student;
}
