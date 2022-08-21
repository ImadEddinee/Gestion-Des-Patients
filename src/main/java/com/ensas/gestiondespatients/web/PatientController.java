package com.ensas.gestiondespatients.web;

import com.ensas.gestiondespatients.entities.Appointment;
import com.ensas.gestiondespatients.entities.Patient;
import com.ensas.gestiondespatients.service.AppointmentService;
import com.ensas.gestiondespatients.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @GetMapping(path = "/patients")
    public String getPatients(Model model,
             @RequestParam(name = "page",defaultValue = "0") int page,
             @RequestParam(name = "size",defaultValue = "5") int size,
             @RequestParam(name = "keyword",defaultValue = "") String keyword,
             @RequestParam(name = "filtre",defaultValue = "all") String filtre){
        Page<Patient> patientPage = patientService.getAllPatients(filtre,keyword,page,size);
        model.addAttribute("patients", patientPage.getContent());
        model.addAttribute("navigation", new int[]{page,page+1,page+2});
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", patientPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("filtre", filtre);
        model.addAttribute("totalPatients", patientPage.getTotalElements());
        model.addAttribute("title", "Patients");
        return "patient/listPatients";
    }

    @GetMapping("/patients/{id}/appointments")
    public String getAppointments(@PathVariable(name = "id") Long id,Model model){
        List<Appointment> appointments = appointmentService.getPatientAppointments(id);
        model.addAttribute("appointments", appointments);
        model.addAttribute("title", "Appointments");
        return "appointment/listAppointments";
    }
}
