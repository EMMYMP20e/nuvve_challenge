package com.nuvve.challenge.services;

import com.nuvve.challenge.mappers.VehicleMapper;
import com.nuvve.challenge.models.Vehicle;
import com.nuvve.challenge.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    public List<Vehicle> getAll(){
        return vehicleRepository.findAll().stream().map(vehicleMapper::toVehicle).collect(Collectors.toList());
    }

    public Vehicle create(Vehicle vehicle){
        return vehicleMapper.toVehicle(vehicleRepository.save(vehicleMapper.toVehicleEntity(vehicle)));
    }

    public Vehicle update(Vehicle vehicle){
         vehicleRepository.findById(vehicle.getIdVehicule())//and user
                 .orElseThrow(() -> new EmptyResultDataAccessException(
                         String.format("Error updating vehicle with id %d: Vehicle not found",vehicle.getIdVehicule()), 1
                 ));
         return vehicleMapper.toVehicle(vehicleRepository.save(vehicleMapper.toVehicleEntity(vehicle)));
    }

    public boolean delete(Integer id){
        try {
            vehicleRepository.deleteById(id);//and user
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }




 }
