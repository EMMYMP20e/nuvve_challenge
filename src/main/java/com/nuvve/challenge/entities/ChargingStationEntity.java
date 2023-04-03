package com.nuvve.challenge.entities;

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
@Table(name = "charging_stations")
public class ChargingStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cs")
    private Integer idCS;

    @Column(name = "id_grid")
    private Integer idGrid;

    @Column(name = "id_vehicle")
    private Integer idVehicle;

    @Column(name = "state")
    private String state;

}
