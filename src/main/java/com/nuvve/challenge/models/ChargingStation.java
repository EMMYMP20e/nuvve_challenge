package com.nuvve.challenge.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ChargingStation {

    private Integer idCS;

    private Integer idGrid;

    private Integer idVehicle;

    private String state;
}
