package rw.bk.codingchallenge.taxi24.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.dto.DriverDto;
import rw.bk.codingchallenge.taxi24.enums.EDriverStatus;
import rw.bk.codingchallenge.taxi24.repository.DriverRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService implements rw.bk.codingchallenge.taxi24.service.DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverDto createOne(DriverDto driverDto) throws InvocationTargetException, IllegalAccessException {
        Driver driver = new Driver();

        //Convert DriverDto to Driver
        BeanUtils.copyProperties(driver, driverDto);
        driver.setRegistrationDate(new Date());
        driver.setDriverStatus(EDriverStatus.AVAILABLE);
        Driver response = driverRepository.save(driver);

        //Convert Driver Response to DriverDto
        BeanUtils.copyProperties(driverDto, driver);
        return driverDto;
    }

    @Override
    public List<Driver> allAvailableDrivers() {
        List<Driver> availableDrivers = this.driverRepository.findByDriverStatus(EDriverStatus.AVAILABLE);
        return availableDrivers;
    }

    @Override
    public List<Driver> driversAvailableNearby() {
        return null;
    }

    @Override
    public List<Driver> driversNearbyRider(UUID riderId) {
        return null;
    }

    @Override
    public DriverDto findByNationalId(String nationalId) throws InvocationTargetException, IllegalAccessException {
        Driver driver = driverRepository.findByNationalId(nationalId);
        if (driver != null){
            DriverDto driverDto = new DriverDto();
            BeanUtils.copyProperties(driverDto, driver);
            return driverDto;
        }
        return null;
    }

//    @Override
//    public DriverDto findOne(UUID driverId) throws InvocationTargetException, IllegalAccessException {
//        Optional<Driver> driver = driverRepository.findById(driverId);
//        if (driver.isPresent()){
//            DriverDto driverDto = new DriverDto();
//            BeanUtils.copyProperties(driverDto, driver);
//            return driverDto;
//        }
//        return null;
//    }
}
