package com.nuvve.challenge.mappers;

import com.nuvve.challenge.entities.VehicleEntity;
import com.nuvve.challenge.models.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleMapper {
    public Vehicle toVehicle(VehicleEntity entity){
        return Vehicle.builder()
                .idVehicle(entity.getIdVehicle())
                .idUser(entity.getIdUser())
                .battery(entity.getBattery())
                .nextDistance(entity.getNextDistance())
                .scheduledTime(entity.getScheduledTime())
                .state(entity.getState())
                .build();
    }
    public VehicleEntity toVehicleEntity (Vehicle vehicle){
        return VehicleEntity.builder()
                .idVehicle(vehicle.getIdVehicle())
                .idUser(vehicle.getIdUser())
                .battery(vehicle.getBattery())
                .nextDistance(vehicle.getNextDistance())
                .scheduledTime(vehicle.getScheduledTime())
                .state(vehicle.getState())
                .build();
    }
}
