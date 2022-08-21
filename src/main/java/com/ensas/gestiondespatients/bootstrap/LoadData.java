package com.ensas.gestiondespatients.bootstrap;

import com.ensas.gestiondespatients.entities.Doctor;
import com.ensas.gestiondespatients.entities.Speciality;
import com.ensas.gestiondespatients.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }
    @Transactional
    void loadData(){
        Doctor doctor = new Doctor();
        doctor.setFirstName("Yassine");
        doctor.setLastName("Eddine");
        doctor.setEmail("yassine@gmail.com");
        doctor.setPhoneNumber("0575438647");
        doctor.setAddress("Tanger avenue al amal 89");
        doctor.setSpeciality(Speciality.CARDIOLOGY);
        doctorRepository.save(doctor);
        doctor = new Doctor();
        doctor.setFirstName("Yassine");
        doctor.setLastName("Eddine");
        doctor.setEmail("yassine@gmail.com");
        doctor.setPhoneNumber("0575438647");
        doctor.setAddress("Tanger avenue al amal 89");
        doctor.setSpeciality(Speciality.DERMATOLOGY);
        doctorRepository.save(doctor);
        doctor = new Doctor();
        doctor.setFirstName("Yassine");
        doctor.setLastName("Eddine");
        doctor.setEmail("yassine@gmail.com");
        doctor.setPhoneNumber("0575438647");
        doctor.setAddress("Tanger avenue al amal 89");
        doctor.setSpeciality(Speciality.DERMATOLOGY);
        doctorRepository.save(doctor);
        doctor = new Doctor();
        doctor.setFirstName("Yassine");
        doctor.setLastName("Eddine");
        doctor.setEmail("yassine@gmail.com");
        doctor.setPhoneNumber("0575438647");
        doctor.setAddress("Tanger avenue al amal 89");
        doctor.setSpeciality(Speciality.PATHOLOGY);
        doctorRepository.save(doctor);
    }
}
