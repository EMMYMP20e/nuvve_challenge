package com.nuvve.challenge.models;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class Vehicle {
    private Integer idVehicle;

    private Integer idUser;

    private Integer battery;

    private Integer nextDistance;

    private LocalDateTime scheduledTime;

    private String state;
}
