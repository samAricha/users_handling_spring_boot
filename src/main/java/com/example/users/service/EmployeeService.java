package com.example.users.service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Employee;
import com.example.users.model.Manager;
import com.example.users.repository.EmployeeRepository;
import com.example.users.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
    private EmployeeRepository employeeRepository;

    public void registerEmployee(Employee employee) {
       employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmployeeById(long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with the stated Id doesn't exist"));

        return ResponseEntity.ok(employee);
    }


}
