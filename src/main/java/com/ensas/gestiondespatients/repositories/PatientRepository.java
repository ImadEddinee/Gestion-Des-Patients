package com.ensas.gestiondespatients.repositories;

import com.ensas.gestiondespatients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where concat(lower(p.firstName) ,' ',lower(p.lastName) ) LIKE :kw")
    Page<Patient> findPatientByFullName(@Param("kw") String keyword, Pageable pageable);
    @Query("select p from Patient p where concat(lower(p.firstName) ,' ',lower(p.lastName) ) LIKE :kw and p.appointments.size > 0")
    Page<Patient> getPatientWithAppointment(@Param("kw") String keyword, Pageable pageable);
}
