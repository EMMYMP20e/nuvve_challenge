package com.nuvve.challenge.services;

import com.nuvve.challenge.mappers.ChargingStationMapper;
import com.nuvve.challenge.mappers.VehicleMapper;
import com.nuvve.challenge.models.ChargingStation;
import com.nuvve.challenge.models.Vehicle;
import com.nuvve.challenge.repositories.ChargingStationRepository;
import com.nuvve.challenge.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChargingStationService {
    private final VehicleRepository vehicleRepository;
    private final ChargingStationRepository chargingStationRepository;
    private final ChargingStationMapper chargingStationMapper;

    public List<ChargingStation> getAll(){
        return chargingStationRepository.findAll().stream().map(chargingStationMapper::toChargingStation).collect(Collectors.toList());
    }

    public ChargingStation v2g(Integer vehicleId, Integer csId){
        vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EmptyResultDataAccessException(
                        String.format("Error updating vehicle with id %d: Vehicle not found",vehicleId), 1
                ));
        var cs = chargingStationRepository.findCSAvailable(csId)
                .orElseThrow(() -> new EmptyResultDataAccessException(
                        String.format("Error updating charging station with id %d: Charging Station not found or not available",csId), 1
                ));
        cs.setIdVehicle(vehicleId);
        cs.setState("busy");
        return chargingStationMapper.toChargingStation(chargingStationRepository.save(cs));
    }

    public ChargingStation disconnect(Integer vehicleId, Integer csId) {
        var cs = chargingStationRepository.findCSBusy(csId, vehicleId)
                .orElseThrow(() -> new EmptyResultDataAccessException(
                        String.format("Error updating charging station with id %d: Charging Station or vehicle not found", csId), 1
                ));
        cs.setIdVehicle(null);
        cs.setState("available");
        return chargingStationMapper.toChargingStation(chargingStationRepository.save(cs));
    }
}
