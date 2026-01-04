package com.example.educationpractice.controller.dto.response;

import com.example.educationpractice.service.dto.StudentServiceDto;
import com.example.educationpractice.service.dto.TeacherServiceDto;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JacksonComponent;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Student")
public class StudentResponseDto {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
    private UniversityServiceDto university;
    private TeacherServiceDto teacher;

    public StudentResponseDto(Integer id) {
        this.id = id;
    }

}
