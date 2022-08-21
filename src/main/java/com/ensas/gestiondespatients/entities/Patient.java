package com.ensas.gestiondespatients.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor
@Table(name = "PATIENT")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
