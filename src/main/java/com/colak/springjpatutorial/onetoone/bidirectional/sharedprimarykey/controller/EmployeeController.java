package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.controller;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.ParkingSpace;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.mapstruct.EmployeeMapper;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.dto.EmployeeDTO;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.EmployeeService;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final ParkingSpaceService parkingSpaceService;

    private final EmployeeService employeeService;


    @PostMapping("/save")
    public Employee saveEmp(@RequestBody EmployeeDTO employeeDTO) {
        //creating ParkingSpace object and setting properties
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setName(employeeDTO.getName() + " parking space");

        //saving employee into db
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDTO);
        employee.setName(employeeDTO.getName());
        employee.setParkingSpace(parkingSpace);
        employeeService.save(employee);

        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/parkingspaces")
    public List<ParkingSpace> getAddressList() {
        return parkingSpaceService.findAll();
    }
}
