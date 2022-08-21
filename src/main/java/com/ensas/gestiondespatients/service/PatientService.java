package com.ensas.gestiondespatients.service;

import com.ensas.gestiondespatients.entities.Patient;
import com.ensas.gestiondespatients.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Page<Patient> getAllPatients(String filtre,String keyword,int page,int size){
        Page<Patient> patientPage = null;
        keyword = "%" + keyword.toLowerCase() + "%";
        filtre = filtre.toLowerCase();
        if (filtre.equals("rdv")){
            patientPage = patientRepository
                    .getPatientWithAppointment(keyword, PageRequest.of(page, size));
        }else{
            patientPage = patientRepository
                    .findPatientByFullName(keyword, PageRequest.of(page, size));
        }
        return patientPage;
    }
}
