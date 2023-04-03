package com.nuvve.challenge.mappers;

import com.nuvve.challenge.entities.ChargingStationEntity;
import com.nuvve.challenge.models.ChargingStation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChargingStationMapper {
    public ChargingStation toChargingStation(ChargingStationEntity entity){
        return ChargingStation.builder()
                .idCS(entity.getIdCS())
                .idGrid(entity.getIdGrid())
                .idVehicle(entity.getIdVehicle())
                .state(entity.getState())
                .build();
    }

    public ChargingStationEntity toChargingStationEntity (ChargingStation chargingStation){
        return ChargingStationEntity.builder()
                .idCS(chargingStation.getIdCS())
                .idGrid(chargingStation.getIdGrid())
                .idVehicle(chargingStation.getIdVehicle())
                .state(chargingStation.getState())
                .build();
    }
}
