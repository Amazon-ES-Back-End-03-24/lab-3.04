package org.ironhack.lab304.repository;

import org.ironhack.lab304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAircraftContaining(String aircraft);

    List<Flight> findByFlightMileageGreaterThan(Long mileage);
}
