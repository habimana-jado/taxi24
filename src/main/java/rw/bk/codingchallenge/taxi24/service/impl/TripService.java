package rw.bk.codingchallenge.taxi24.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.domain.Rider;
import rw.bk.codingchallenge.taxi24.domain.Trip;
import rw.bk.codingchallenge.taxi24.dto.TripDto;
import rw.bk.codingchallenge.taxi24.enums.EDriverStatus;
import rw.bk.codingchallenge.taxi24.enums.ETripStatus;
import rw.bk.codingchallenge.taxi24.repository.DriverRepository;
import rw.bk.codingchallenge.taxi24.repository.RiderRepository;
import rw.bk.codingchallenge.taxi24.repository.TripRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TripService implements rw.bk.codingchallenge.taxi24.service.TripService {

    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final TripRepository tripRepository;

    public TripService(DriverRepository driverRepository, RiderRepository riderRepository, TripRepository tripRepository) {
        this.driverRepository = driverRepository;
        this.riderRepository = riderRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public TripDto createOne(TripDto tripDto) throws InvocationTargetException, IllegalAccessException {
        Driver driver = this.driverRepository.findByNationalId(tripDto.getDriverNationalId());
        Rider rider = this.riderRepository.findByNationalId(tripDto.getRiderNationalId());

        Trip trip = new Trip();
        BeanUtils.copyProperties(trip, tripDto);
        trip.setTripStatus(ETripStatus.ACTIVE);
        trip.setTripStartPeriod(new Date());
        trip.setDriver(driver);
        trip.setRider(rider);

        Trip response = this.tripRepository.save(trip);

        driver.setDriverStatus(EDriverStatus.TAKEN);
        this.driverRepository.save(driver);

        BeanUtils.copyProperties(tripDto, response);
        return tripDto;
    }

    @Override
    public TripDto completeTrip(UUID tripId) throws InvocationTargetException, IllegalAccessException {
        Trip trip = this.tripRepository.findById(tripId)
                .orElseThrow(() -> new IllegalArgumentException("Trip Id Not Found " + tripId));
        trip.setTripStatus(ETripStatus.COMPLETED);
        trip.setTripEndPeriod(new Date());
        Trip response = this.tripRepository.save(trip);

        Driver driver = trip.getDriver();
        driver.setDriverStatus(EDriverStatus.AVAILABLE);
        this.driverRepository.save(driver);

        TripDto tripDto = new TripDto();
        BeanUtils.copyProperties(tripDto, trip);
        return tripDto;
    }

    @Override
    public List<Trip> findActiveTrips() {
        return this.tripRepository.findByTripStatus(ETripStatus.ACTIVE);
    }
}
