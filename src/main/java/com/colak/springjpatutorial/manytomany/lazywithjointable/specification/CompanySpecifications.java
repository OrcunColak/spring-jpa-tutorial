package com.colak.springjpatutorial.manytomany.lazywithjointable.specification;

import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Company;
import com.colak.springjpatutorial.manytomany.lazywithjointable.jpa.Project;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CompanySpecifications {

    /**
     * Example for CriteriaBuilder#equal()
     */
    public static Specification<Company> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    /**
     * Example for Expression#in()
     */
    public static Specification<Company> hasNames(List<String> names) {
        return (root, query, criteriaBuilder) -> root.get("name").in(names);
    }

    /**
     * Example for CriteriaBuilder#between()
     */
    public static Specification<Company> isWithinIdRange(int min, int max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("id"), min, max);
    }

    public static Specification<Company> hasAtLeastProjects(int minProjects) {
        return (root, query, criteriaBuilder) -> {
            Join<Company, Project> projects = root.join("projects");
            query.groupBy(root.get("id"));
            Expression<Long> projectCount = criteriaBuilder.count(projects);
            criteriaBuilder.greaterThanOrEqualTo(projectCount, Long.valueOf(minProjects));
            return query.getRestriction();
        };
    }
}
