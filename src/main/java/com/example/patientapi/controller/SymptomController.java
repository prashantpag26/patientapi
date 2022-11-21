package com.example.patientapi.controller;

import com.example.patientapi.model.CovidSymptoms;
import com.example.patientapi.model.GeneralResponse;
import com.example.patientapi.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomController {
    @Autowired
    private SymptomRepository symptomRepository;

    @GetMapping("/")
    public Collection<CovidSymptoms> getAllPatientSymptom() {
        return symptomRepository.getAllPatientSymptom();
    }

    @GetMapping("/{patientId}")
    public CovidSymptoms getPatientSymptomById(@PathVariable("patientId") String patientId) {
        return symptomRepository.getPatientSymptomById(patientId);
    }

    @PostMapping("/addSymptoms")
    public GeneralResponse addPatientSymptom(@RequestBody CovidSymptoms symptoms) {
        return symptomRepository.addPatientSymptom(symptoms);
    }

    @GetMapping("delete/{patientId}")
    public GeneralResponse deletePatientSymptom(@PathVariable("patientId") String patientId){
        return symptomRepository.deletePatientSymptom(patientId);
    }

}
