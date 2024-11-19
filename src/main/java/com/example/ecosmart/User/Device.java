package com.example.ecosmart.User;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "devices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private boolean status; // true = ligado, false = desligado
    private double powerRating; // Potência em watts
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user; // Relacionamento com o proprietário do dispositivo

}
