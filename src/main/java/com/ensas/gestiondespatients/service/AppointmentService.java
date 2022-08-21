package com.ensas.gestiondespatients.service;

import com.ensas.gestiondespatients.entities.Appointment;
import com.ensas.gestiondespatients.repositories.AppointmentRepository;
import com.ensas.gestiondespatients.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public List<Appointment> getPatientAppointments(Long id){
        patientRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("no patient with id"));
        return appointmentRepository.findByPatientId(id);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}
