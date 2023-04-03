package com.nuvve.challenge.repositories;

import com.nuvve.challenge.entities.ChargingStationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChargingStationRepository extends JpaRepository<ChargingStationEntity, Integer> {

    @Query(value = "SELECT a FROM ChargingStationEntity AS a " +
            "WHERE a.idCS = :idCS AND a.idVehicle IS NULL AND a.state = 'available'")
    Optional<ChargingStationEntity> findCSAvailable(Integer idCS);

    @Query(value = "SELECT a FROM ChargingStationEntity AS a " +
            "WHERE a.idCS = :idCS AND a.idVehicle = :idVehicle AND a.state = 'busy'")
    Optional<ChargingStationEntity> findCSBusy(Integer idCS, Integer idVehicle);
}
