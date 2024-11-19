package com.example.ecosmart.User;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Consumption")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount; // Consumo em kWh
    private LocalDateTime timestamp; // Data e hora do registro

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

}