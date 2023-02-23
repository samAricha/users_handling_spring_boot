package com.example.users.controller;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Employee;
import com.example.users.model.Manager;
import com.example.users.repository.EmployeeRepository;
import com.example.users.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;



    @GetMapping
    public List<Manager> getAllManagers(){
        return managerService.getAllManagers();
    }

    // Endpoint to register an employee as a manager
    @PostMapping("/{employeeId}/register-manager")
    public ResponseEntity<?> registerManager(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody Manager manager) {



        try {
            managerService.registerManager(employeeId, manager.getDepartment());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
