package com.example.educationpractice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequestDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;

    private Integer universityId; // ✔ sadəcə ID
}
