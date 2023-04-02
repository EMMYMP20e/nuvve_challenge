package com.nuvve.challenge.controller;

import com.nuvve.challenge.models.Vehicle;
import com.nuvve.challenge.services.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController{
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.create(vehicle),  HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Vehicle vehicle) {
        try{
            return new ResponseEntity<>(vehicleService.update(vehicle),  HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer vehicleId) {
        if (vehicleService.delete(vehicleId)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
