package com.nuvve.challenge.repositories;

import com.nuvve.challenge.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {


}
