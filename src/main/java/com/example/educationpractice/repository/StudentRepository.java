package com.example.educationpractice.repository;

import com.example.educationpractice.repository.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {

    @Query("SELECT s FROM StudentEntity s JOIN s.teachers t WHERE t.id = :teacherId")
    List<StudentEntity> findStudentsByTeacherId(@Param("teacherId") Integer teacherId);
}
