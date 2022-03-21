package rw.bk.codingchallenge.taxi24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.bk.codingchallenge.taxi24.domain.Driver;
import rw.bk.codingchallenge.taxi24.enums.EDriverStatus;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    List<Driver> findByDriverStatus(EDriverStatus status);
    Driver findByNationalId(String nationalId);
}
