package rw.bk.codingchallenge.taxi24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.bk.codingchallenge.taxi24.domain.Trip;
import rw.bk.codingchallenge.taxi24.dto.TripDto;
import rw.bk.codingchallenge.taxi24.enums.ETripStatus;

import java.util.List;
import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {
    List<Trip> findByTripStatus(ETripStatus status);

}
