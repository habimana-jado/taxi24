package rw.bk.codingchallenge.taxi24.dto;

import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.domain.Rider;
import rw.bk.codingchallenge.taxi24.enums.ETripStatus;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class TripDto {

    private ETripStatus tripStatus;
    //Amount to be paid for trip
    private Double charge;
    private String departure;
    private String destination;

    private String riderNationalId;
    private String driverNationalId;

    private Rider rider;
    private Driver driver;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tripStartPeriod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripEndPeriod;

    public ETripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(ETripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getRiderNationalId() {
        return riderNationalId;
    }

    public void setRiderNationalId(String riderNationalId) {
        this.riderNationalId = riderNationalId;
    }

    public String getDriverNationalId() {
        return driverNationalId;
    }

    public void setDriverNationalId(String driverNationalId) {
        this.driverNationalId = driverNationalId;
    }

    public Date getTripStartPeriod() {
        return tripStartPeriod;
    }

    public void setTripStartPeriod(Date tripStartPeriod) {
        this.tripStartPeriod = tripStartPeriod;
    }

    public Date getTripEndPeriod() {
        return tripEndPeriod;
    }

    public void setTripEndPeriod(Date tripEndPeriod) {
        this.tripEndPeriod = tripEndPeriod;
    }
}
