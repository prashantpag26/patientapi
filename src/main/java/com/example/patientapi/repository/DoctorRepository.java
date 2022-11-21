package com.example.patientapi.repository;

import com.example.patientapi.model.Doctor;
import com.example.patientapi.model.GeneralResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class DoctorRepository {
    private final static Map<String, Doctor> doctorMap = new HashMap<>();
    private int doctorId = 100;

    public Collection<Doctor> getDoctorList() {
        return doctorMap.values();
    }

    public Doctor getDoctorById(String doctorId) {
        return doctorMap.get(doctorId);
    }

    public GeneralResponse deleteDoctorById(String doctorId) {
        doctorMap.remove(doctorId);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setId(doctorId);
        generalResponse.setResult("Success");
        return generalResponse;
    }


    public GeneralResponse addDoctor(Doctor doctor) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            doctorId++;
            doctor.setDoctorId("d"+doctorId);
            doctorMap.put("d"+doctorId, doctor);
            generalResponse.setId("d"+doctorId);
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }
    public GeneralResponse updateDoctor(Doctor doctor) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            doctorMap.replace(doctor.getDoctorId(), doctor);
            generalResponse.setId(doctor.getDoctorId());
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }
}
