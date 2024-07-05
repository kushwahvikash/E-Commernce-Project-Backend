package com.vikas.pa.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PASSPORT_TBL")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;
    
    private String passportNumber;
    private String issuingCountry;
    private LocalDate expirationDate;
    
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "personId")
    private Person person;
    
    // Getters and setters
}
