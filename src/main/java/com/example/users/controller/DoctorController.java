package com.example.users.controller;

import com.example.users.model.Doctor;
import com.example.users.model.Manager;
import com.example.users.service.DoctorService;
import com.example.users.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("/{employeeId}/register-doctor")
    public ResponseEntity<?> registerDoctor(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody Doctor doctor) {


        try {
            doctorService.registerDoctor(employeeId, doctor.getSpecialty());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
