package com.ensas.gestiondespatients.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@Table(name = "DOCTOR")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
