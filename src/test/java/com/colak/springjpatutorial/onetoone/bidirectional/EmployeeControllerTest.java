package com.colak.springjpatutorial.onetoone.bidirectional;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.Employee;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.ParkingSpace;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.model.CreateEmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void testListEmployee() {
        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO();
        String employeeName = "orçun";
        createEmployeeDTO.setName(employeeName);

        String saveUrl = "/api/employee/save";

        Employee employee = restTemplate.postForObject(
                saveUrl,
                createEmployeeDTO,
                Employee.class
        );

        assertEquals(1, employee.getId());

        {
            String getUrl = "/api/employee/employees";

            ResponseEntity<List<Employee>> response = restTemplate.exchange(
                    getUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    });
            List<Employee> employeeList = response.getBody();
            Employee firstEmployee = employeeList.get(0);
            assertEquals(1, firstEmployee.getId());
            assertEquals(employeeName, firstEmployee.getName());
            assertEquals(1, firstEmployee.getParkingSpace().getId());
        }
        {
            String getUrl = "/api/employee/parkingspaces";
            ResponseEntity<List<ParkingSpace>> response = restTemplate.exchange(
                    getUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    });
            List<ParkingSpace> parkingSpaceList = response.getBody();

            ParkingSpace firstParkingSpace = parkingSpaceList.get(0);
            assertEquals(1, firstParkingSpace.getId());
            assertEquals(1, firstParkingSpace.getEmployee().getId());
            assertEquals(employeeName, firstParkingSpace.getEmployee().getName());
        }
    }

}
