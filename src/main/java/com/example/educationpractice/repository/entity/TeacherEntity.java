package com.example.educationpractice.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher")
@DynamicUpdate
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private Integer age;
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

    // Student əlaqələri
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TeacherStudentEntity> studentLinks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> students;
}

