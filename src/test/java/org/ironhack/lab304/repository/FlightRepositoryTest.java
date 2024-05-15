package org.ironhack.lab304.repository;

import org.ironhack.lab304.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Flight flight1 = new Flight("B120", "Airbus 330", 236, 4370L);
        Flight flight2 = new Flight("B220","Boeing 747", 400, 135L);
        Flight flight3 = new Flight("B230", "Boeing 777", 300, 615L);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
    }

    @AfterEach
    public void tearDown() {
        flightRepository.deleteAll();
        customerRepository.deleteAll();
    }

    @Test
    void saveFlight_successful() {
        assertEquals(3, flightRepository.findAll().size());
        flightRepository.save(new Flight("B240", "Boeing 777", 300, 600L));
        assertEquals(4, flightRepository.findAll().size());
    }


    @Test
    void findByNumber_validNumber_Flight() {
        Optional<Flight> flightOptional = flightRepository.findByFlightNumber("B220");
        assertTrue(flightOptional.isPresent());
        assertEquals("Boeing 747", flightOptional.get().getAircraft());
    }

    @Test
    void findByModelContains_model_Flights() {
        assertEquals(2, flightRepository.findByAircraftContaining("Boeing").size());
    }

    @Test
    void findByFlightMileageGreaterThan_miles_Flights() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(500L);
        assertEquals(2, flights.size());
        assertEquals("B120", flights.getFirst().getFlightNumber());
    }
}