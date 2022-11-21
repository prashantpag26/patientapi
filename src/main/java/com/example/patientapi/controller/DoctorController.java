package com.example.patientapi.controller;

import com.example.patientapi.model.Doctor;
import com.example.patientapi.model.GeneralResponse;
import com.example.patientapi.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/")
    public Collection<Doctor> getDoctorList(){
        return doctorRepository.getDoctorList();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") String doctorId){
        return doctorRepository.getDoctorById(doctorId);
    }

    @PostMapping("/addDoctor")
    public GeneralResponse addDoctor(@RequestBody Doctor patient){
        return doctorRepository.addDoctor(patient);
    }

    @PostMapping("/updateDoctor")
    public GeneralResponse updateDoctor(@RequestBody Doctor patient){
        return doctorRepository.updateDoctor(patient);
    }

    @GetMapping("delete/{doctorId}")
    public GeneralResponse deleteDoctorById(@PathVariable("doctorId") String doctorId){
        return doctorRepository.deleteDoctorById(doctorId);
    }


}
