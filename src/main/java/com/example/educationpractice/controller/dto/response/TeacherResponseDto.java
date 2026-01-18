package com.example.educationpractice.controller.dto.response;

import com.example.educationpractice.controller.dto.response.UniversityResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;
    private UniversityResponseDto university;

    public TeacherResponseDto(Integer id) {
        this.id = id;
    }
}
