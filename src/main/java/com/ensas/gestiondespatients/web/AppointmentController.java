package com.ensas.gestiondespatients.web;

import com.ensas.gestiondespatients.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable("id") Long id){
        appointmentService.deleteAppointment(id);
    }
}
