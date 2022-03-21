package rw.bk.codingchallenge.taxi24.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DriverDto {

    private String driverNames;
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    private String nationalId;

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
