package com.ensas.gestiondespatients.web;

import com.ensas.gestiondespatients.entities.Doctor;
import com.ensas.gestiondespatients.entities.Patient;
import com.ensas.gestiondespatients.entities.Speciality;
import com.ensas.gestiondespatients.service.DoctorService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("doctors")
    public String getDoctors(Model model,
                             @RequestParam(name = "page",defaultValue = "0") int page,
                             @RequestParam(name = "size",defaultValue = "5") int size,
                             @RequestParam(name = "keyword",defaultValue = "") String keyword,
                             @RequestParam(name = "filtre",defaultValue = "all") String filtre){
        Page<Doctor> doctorPage = doctorService.getDoctors(filtre,keyword,page,size);
        model.addAttribute("doctors", doctorPage.getContent());
        model.addAttribute("navigation", new int[]{page,page+1,page+2});
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", doctorPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("filtre", filtre);
        model.addAttribute("specialities", Speciality.values());
        model.addAttribute("totalDoctors", doctorPage.getTotalElements());
        model.addAttribute("title", "Doctors");
        return "doctor/listDoctors";
    }
}
