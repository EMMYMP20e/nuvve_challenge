package com.nuvve.challenge.controller;

import com.nuvve.challenge.models.ChargingStation;
import com.nuvve.challenge.models.Vehicle;
import com.nuvve.challenge.services.ChargingStationService;
import com.nuvve.challenge.services.VehicleService;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ChargingStationService chargingStationService;

    @GetMapping("/all")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.create(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Vehicle vehicle) {
        try {
            return new ResponseEntity<>(vehicleService.update(vehicle), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer vehicleId) {
        if (vehicleService.delete(vehicleId)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}/v2g")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<ChargingStation> v2g(@PathVariable("id") Integer vehicleId, @RequestBody ChargingStation cs) {
        try {
            return new ResponseEntity<>(chargingStationService.v2g(vehicleId, cs.getIdCS()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all-grids")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ChargingStation>> getAllGrids() {
        return new ResponseEntity<>(chargingStationService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/{id}/disconnect")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<ChargingStation> disconnect(@PathVariable("id") Integer vehicleId, @RequestBody ChargingStation cs) {
        try {
            return new ResponseEntity<>(chargingStationService.disconnect(vehicleId, cs.getIdCS()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
