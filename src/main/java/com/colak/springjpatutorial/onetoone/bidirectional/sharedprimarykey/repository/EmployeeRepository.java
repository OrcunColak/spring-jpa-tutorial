package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.repository;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
