package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.mapstruct;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee dtoToEmployee(EmployeeDTO employeeDTO);
}
