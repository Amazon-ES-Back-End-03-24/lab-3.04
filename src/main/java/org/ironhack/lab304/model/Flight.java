package org.ironhack.lab304.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "aircraft")
    private String aircraft;

    @Column(name = "total_aircraft_seats")
    private Integer totalAircraftSeats;

    @Column(name = "flight_mileage")
    private Long flightMileage;

    @OneToMany(mappedBy = "flight")
    List<FlightBooking> bookings;

    public Flight() {
    }

    public Flight(Integer flightId, String flightNumber, String aircraft, Integer totalAircraftSeats, Long flightMileage, List<FlightBooking> bookings) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
        this.bookings = bookings;
    }

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Long flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(Integer totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public Long getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(Long flightMileage) {
        this.flightMileage = flightMileage;
    }

    public List<FlightBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<FlightBooking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft) && Objects.equals(totalAircraftSeats, flight.totalAircraftSeats) && Objects.equals(flightMileage, flight.flightMileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, aircraft, totalAircraftSeats, flightMileage);
    }
}
