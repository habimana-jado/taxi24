package rw.bk.codingchallenge.taxi24.service;

import rw.bk.codingchallenge.taxi24.domain.Trip;
import rw.bk.codingchallenge.taxi24.dto.TripDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public interface TripService {

    TripDto createOne(TripDto tripDto) throws InvocationTargetException, IllegalAccessException;
    TripDto completeTrip(UUID tripId) throws InvocationTargetException, IllegalAccessException;
    List<Trip> findActiveTrips();
}
