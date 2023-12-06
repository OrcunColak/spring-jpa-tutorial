package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.impl;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.repository.EmployeeRepository;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void save(Employee emp) {
        employeeRepository.save(emp);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
