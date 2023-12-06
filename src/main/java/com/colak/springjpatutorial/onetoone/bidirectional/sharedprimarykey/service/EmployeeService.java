package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee emp);
    List<Employee> findAll();
}
