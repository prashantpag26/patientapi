package com.example.patientapi.repository;

import com.example.patientapi.model.Department;
import com.example.patientapi.model.GeneralResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class DepartmentRepository {

    private final static Map<String, Department> departmentMap = new HashMap<>();
    private int departmentId = 1000;

    public Department getDepartmentById(String patientId) {
        return departmentMap.get(patientId);
    }

    public Collection<Department> getAllDepartment() {
        return departmentMap.values();
    }

    public GeneralResponse addDepartment(Department department) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            departmentId++;
            department.setDepartmentId("d" + departmentId);
            departmentMap.put(department.getDepartmentId(), department);
            generalResponse.setId("d" + departmentId);
            generalResponse.setResult("Success");
        } catch (Exception e) {
            System.out.println("Failure " + e.getMessage());
            generalResponse.setId(String.valueOf(-1));
            generalResponse.setResult("Failure");
        }
        return generalResponse;
    }

    public GeneralResponse deleteDepartment(String departmentId) {
        departmentMap.remove(departmentId);
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setId(departmentId);
        generalResponse.setResult("Success");
        return generalResponse;    }
}
