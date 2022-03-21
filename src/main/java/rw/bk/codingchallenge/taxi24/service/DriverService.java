package rw.bk.codingchallenge.taxi24.service;

import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.dto.DriverDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public interface DriverService {

    DriverDto createOne(DriverDto driver) throws InvocationTargetException, IllegalAccessException;

    List<Driver> allAvailableDrivers();
    List<Driver> driversAvailableNearby();
    List<Driver> driversNearbyRider(UUID riderId);
    DriverDto findByNationalId(String nationalId) throws InvocationTargetException, IllegalAccessException;
}
