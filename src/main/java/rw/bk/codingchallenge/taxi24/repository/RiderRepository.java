package rw.bk.codingchallenge.taxi24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.bk.codingchallenge.taxi24.domain.Rider;

import java.util.UUID;

@Repository
public interface RiderRepository extends JpaRepository<Rider, UUID> {
    Rider findByNationalId(String nationalId);
}
