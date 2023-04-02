package com.nuvve.challenge.repositories;

import com.nuvve.challenge.entities.VehiculeEntity;
import com.nuvve.challenge.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehiculeEntity, Integer> {


}
