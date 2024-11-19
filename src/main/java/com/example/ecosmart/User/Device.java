package com.example.ecosmart.User;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private boolean status; // true = ligado, false = desligado
    private double powerRating; // Potência em watts
    @Column(nullable = false)
    private double maxAllowedConsumption;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Consumption> consumptions;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user; // Relacionamento com o proprietário do dispositivo

}
