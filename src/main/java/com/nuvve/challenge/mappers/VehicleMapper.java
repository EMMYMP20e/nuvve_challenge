package com.nuvve.challenge.mappers;

import com.nuvve.challenge.entities.VehiculeEntity;
import com.nuvve.challenge.models.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VehicleMapper {
    public Vehicle toVehicle(VehiculeEntity entity){
        return Vehicle.builder()
                .idVehicule(entity.getIdVehicule())
                .idUser(entity.getIdUser())
                .battery(entity.getBattery())
                .nextDistance(entity.getNextDistance())
                .scheduledTime(entity.getScheduledTime())
                .state(entity.getState())
                .build();
    }
    public VehiculeEntity toVehicleEntity (Vehicle vehicle){
        return VehiculeEntity.builder()
                .idVehicule(vehicle.getIdVehicule())
                .idUser(vehicle.getIdUser())
                .battery(vehicle.getBattery())
                .nextDistance(vehicle.getNextDistance())
                .scheduledTime(vehicle.getScheduledTime())
                .state(vehicle.getState())
                .build();
    }
}
