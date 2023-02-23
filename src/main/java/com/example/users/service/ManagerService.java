package com.example.users.service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Employee;
import com.example.users.model.Manager;
import com.example.users.repository.EmployeeRepository;
import com.example.users.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void registerManager(Long id, String department) {

        // Retrieve employee from database
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found."));

        Manager manager = new Manager();
        manager.setEmployee(employee);
        manager.setDepartment(department);
        managerRepository.save(manager);
    }



    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }



}
