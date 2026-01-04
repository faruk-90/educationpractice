package com.example.educationpractice.repository.specification;

import com.example.educationpractice.repository.entity.StudentEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class StudentSpecification {

    public static Specification<StudentEntity> filter(
            String name,
            String surname,
            Integer age,
            BigDecimal scholarship,
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

                if (scholarship != null) {
                    predicates = criteriaBuilder.and(predicates,
                            criteriaBuilder.equal(root.get("scolarship"), scholarship));
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
