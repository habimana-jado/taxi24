package rw.bk.codingchallenge.taxi24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.bk.codingchallenge.taxi24.domain.Trip;
import rw.bk.codingchallenge.taxi24.dto.TripDto;
import rw.bk.codingchallenge.taxi24.service.TripService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@RestController
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/register-trip")
    public ResponseEntity<?> createOne(@RequestBody TripDto tripDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<TripDto>(tripService.createOne(tripDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-active-trips")
    public ResponseEntity<?> getActiveTrips(){
        return new ResponseEntity<List<Trip>>(tripService.findActiveTrips(), HttpStatus.OK);
    }

    @PostMapping("/complete-trip/{tripId}")
    public ResponseEntity<?> completeTrip(@PathVariable UUID tripId) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<TripDto>(tripService.completeTrip(tripId), HttpStatus.OK);
    }
}
