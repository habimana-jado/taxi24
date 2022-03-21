package rw.bk.codingchallenge.taxi24.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "RIDERS")
public class Rider {
    @Id
    @GeneratedValue
    private UUID riderId;
    private String riderNames;
    private String phoneNumber;
    @Column(nullable = false, unique = true, length = 16)
    private String nationalId;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    public UUID getRiderId() {
        return riderId;
    }

    public void setRiderId(UUID riderId) {
        this.riderId = riderId;
    }

    public String getRiderNames() {
        return riderNames;
    }

    public void setRiderNames(String riderNames) {
        this.riderNames = riderNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
