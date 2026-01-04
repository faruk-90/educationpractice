package com.example.educationpractice.repository.specification;

import com.example.educationpractice.repository.entity.TeacherEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class TeacherSpecification {

    public static Specification<TeacherEntity> filter(
            String name,
            String surname,
            Integer age,
            BigDecimal salary,
            Integer universityId
    ) {
        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                root.fetch("university", JoinType.LEFT);

                Predicate predicates = criteriaBuilder.conjunction();

                if (name != null && !name.isBlank()) {
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.like(root.get("name"), "%" + name + "%"));
                }

                if (surname != null && !surname.isBlank()) {
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.like(root.get("surname"), "%" + surname + "%"));
                }

                if (age != null) {
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.equal(root.get("age"), age));
                }

                if (salary != null) {
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.equal(root.get("salary"), salary));
                }

                if (universityId != null) {
                    Join<Object, Object> universityJoin = root.join("university");
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.equal(universityJoin.get("id"), universityId));
                }

                return predicates;
            }

        };

    }

}
