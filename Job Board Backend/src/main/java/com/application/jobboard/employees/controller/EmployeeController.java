package com.application.jobboard.employees.controller;

import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.employees.domain.Employee;
import com.application.jobboard.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final String entityType="Employee";

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee/register")
    Employee newEmployee(@RequestBody Employee registerEmployee) {

        return employeeRepository.save(registerEmployee);

    }

    @GetMapping("/employee/all-employees")
    List<Employee> getAllEmployees() {

        return employeeRepository.findAll();

    }

    @GetMapping("/employee/{getEmployeeById}")
    Employee getEmployeeById(Long getEmployeeById){
        return employeeRepository.findById(getEmployeeById)
                .orElseThrow(() -> new EntityNotFoundException(getEmployeeById, entityType));
    }

    @PutMapping("/employee/update/{idOfEmployeeToBeUpdated}")
    Employee updateEmployee(@RequestBody Employee updateEmployee, @PathVariable Long idOfEmployeeToBeUpdated) {

        return employeeRepository.findById(idOfEmployeeToBeUpdated)
                .map(employee -> {

                    employee.setEmployeeFirstName(updateEmployee.getEmployeeFirstName());

                    employee.setEmployeeLastName(updateEmployee.getEmployeeLastName());

                    employee.setEmployeeEmailAddress(updateEmployee.getEmployeeEmailAddress());

                    employee.setEmployeePassword(updateEmployee.getEmployeePassword());

                    employee.setEmployeePhoneNumber(updateEmployee.getEmployeePhoneNumber());

                    return employeeRepository.save(employee);

                })
                .orElseThrow(() -> new EntityNotFoundException(idOfEmployeeToBeUpdated, entityType));
    }

    @DeleteMapping("/employee/delete/{idOfEmployeeToBeDeleted}")
    void deleteEmployee(@PathVariable Long idOfEmployeeToBeDeleted) {
        if(employeeRepository.existsById(idOfEmployeeToBeDeleted)) {
            employeeRepository.deleteById(idOfEmployeeToBeDeleted);
        }
        else {
            throw new EntityNotFoundException(idOfEmployeeToBeDeleted, entityType);
        }
    }


}
