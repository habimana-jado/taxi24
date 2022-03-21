package rw.bk.codingchallenge.taxi24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.dto.DriverDto;
import rw.bk.codingchallenge.taxi24.service.DriverService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping(value = "/register-driver")
    public ResponseEntity<?> registerDriver(@RequestBody DriverDto driverDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<DriverDto>(this.driverService.createOne(driverDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/available-drivers")
    public ResponseEntity<?> getAvailableDrivers() {
        return new ResponseEntity<List<Driver>>(this.driverService.allAvailableDrivers(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-driver/{nationalId}")
    public ResponseEntity<?> getOneDriver(@PathVariable String nationalId) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<DriverDto>(this.driverService.findByNationalId(nationalId), HttpStatus.FOUND);
    }
}
