package com.nuvve.challenge.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private Integer idVehicle;

    @Column(name = "id_user") //TODO id
    private Integer idUser;

    @Column(name = "battery")
    private Integer battery;

    @Column(name = "next_distance") //TODO
    private Integer nextDistance;

    @Column(name = "scheduled_time")//TODO
    private LocalDateTime scheduledTime;

    @Column(name = "state")
    private String state;
}
