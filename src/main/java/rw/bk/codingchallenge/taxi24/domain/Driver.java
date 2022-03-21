package rw.bk.codingchallenge.taxi24.domain;

import rw.bk.codingchallenge.taxi24.enums.EDriverStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @GeneratedValue
    private UUID driverId;
    private String driverNames;
    private String phoneNumber;
    @Column(unique = true, nullable = false, length = 16)
    private String nationalId;
    @Enumerated(EnumType.STRING)
    private EDriverStatus driverStatus;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public UUID getDriverId() {
        return driverId;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public String getDriverNames() {
        return driverNames;
    }

    public void setDriverNames(String driverNames) {
        this.driverNames = driverNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EDriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(EDriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
