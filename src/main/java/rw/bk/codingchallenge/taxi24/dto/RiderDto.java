package rw.bk.codingchallenge.taxi24.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class RiderDto {

    private String riderNames;
    private String phoneNumber;
    private String nationalId;
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

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
