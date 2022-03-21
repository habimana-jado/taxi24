package rw.bk.codingchallenge.taxi24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.bk.codingchallenge.taxi24.domain.Rider;
import rw.bk.codingchallenge.taxi24.dto.RiderDto;
import rw.bk.codingchallenge.taxi24.service.RiderService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping("/register-rider")
    public ResponseEntity<?> registerRider(@RequestBody RiderDto riderDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<RiderDto>(this.riderService.createOne(riderDto), HttpStatus.CREATED);

    }

    @GetMapping("/get-rider/{nationalId}")
    public ResponseEntity<?> getOneRiders(@PathVariable String nationalId) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<RiderDto>(this.riderService.findByNationalId(nationalId), HttpStatus.FOUND);
    }

    @GetMapping("/get-all-riders")
    public ResponseEntity<?> getAllRiders() throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<List<Rider>>(this.riderService.findAllRiders(), HttpStatus.OK);
    }
}
