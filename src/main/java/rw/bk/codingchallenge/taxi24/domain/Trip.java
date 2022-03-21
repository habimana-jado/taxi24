package rw.bk.codingchallenge.taxi24.domain;

import rw.bk.codingchallenge.taxi24.enums.ETripStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TRIPS")
public class Trip {
    @Id
    @GeneratedValue
    private UUID tripId;
    @Enumerated(EnumType.STRING)
    private ETripStatus tripStatus;
    //Amount to be paid for trip
    private Double charge;
    private String departure;
    private String destination;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripStartPeriod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripEndPeriod;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Driver driver;

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

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
