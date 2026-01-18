package com.example.educationpractice.repository;

import com.example.educationpractice.repository.entity.TeacherStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherStudentRepository extends JpaRepository<TeacherStudentEntity, Integer> {


//    List<TeacherStudentEntity> findAllByTeacherId(Integer teacherId);
//    List<TeacherStudentEntity> findAllByStudentId(Integer studentId);
}
