package com.example.users.service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Doctor;
import com.example.users.model.Employee;
import com.example.users.model.Manager;
import com.example.users.repository.DoctorRepository;
import com.example.users.repository.EmployeeRepository;
import com.example.users.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void registerDoctor(Long id, String specialty) {

        // Retrieve employee from database
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found."));

        Doctor doctor = new Doctor();
        doctor.setEmployee(employee);
        doctor.setSpecialty(specialty);
        doctorRepository.save(doctor);
    }
}
