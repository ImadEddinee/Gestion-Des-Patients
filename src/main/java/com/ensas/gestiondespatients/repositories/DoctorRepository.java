package com.ensas.gestiondespatients.repositories;

import com.ensas.gestiondespatients.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query(nativeQuery = true,value = "select * from doctor where speciality = :filtre and concat(lower(first_name),' ',lower(last_name)) like :keyword")
    Page<Doctor> searchBySpeciality(@Param("filtre") String filtre,@Param("keyword") String keyword, Pageable pageable);
    @Query("select d from Doctor d where concat(lower(d.firstName),' ',lower(d.lastName)) like :keyword ")
    Page<Doctor> findDoctorByFullName(@Param("keyword") String keyword, Pageable pageable);
}
