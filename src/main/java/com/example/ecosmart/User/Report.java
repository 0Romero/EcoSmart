package com.example.ecosmart.User;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "report")
@Entity
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceName;
    private String deviceBrand;
    private Double powerConsumption;
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    // Getters and Setters
}
