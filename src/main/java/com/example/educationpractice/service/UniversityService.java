package com.example.educationpractice.service;

import com.example.educationpractice.repository.UniversityRepository;
import com.example.educationpractice.repository.entity.UniversityEntity;
import com.example.educationpractice.service.dto.UniversityServiceDto;
import com.example.educationpractice.service.dto.mapper.UniversityServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository studentRepository) {
        this.universityRepository = studentRepository;
    }

    public List<UniversityServiceDto> getUniversities() {
        List<UniversityEntity> list = universityRepository.findAll();

        return UniversityServiceMapper.INSTANCE.toServiceDtoList(list);
    }

}
