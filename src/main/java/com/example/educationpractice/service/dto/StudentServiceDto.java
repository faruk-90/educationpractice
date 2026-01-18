package com.example.educationpractice.service.dto;

import com.example.educationpractice.service.dto.UniversityServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentServiceDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
    private UniversityServiceDto university;

    // əlaqə YOXDUR
}
