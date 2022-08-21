package com.ensas.gestiondespatients.service;

import com.ensas.gestiondespatients.entities.Doctor;
import com.ensas.gestiondespatients.entities.Speciality;
import com.ensas.gestiondespatients.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Page<Doctor> getDoctors(String filtre, String keyword, int page, int size) {
        Page<Doctor> doctorPage = null;
        keyword = "%" + keyword.toLowerCase() + "%";
        filtre = filtre.toUpperCase();
        for (Speciality speciality : Speciality.values()){
            if (speciality.name().equalsIgnoreCase(filtre)){
                log.info("Searching by ..." + filtre);
                doctorPage = doctorRepository
                        .searchBySpeciality(filtre,keyword, PageRequest.of(page, size));
                break;
            }
        }
        if (doctorPage == null){
            doctorPage = doctorRepository
                    .findDoctorByFullName(keyword, PageRequest.of(page, size));
        }
        return doctorPage;
    }
}
