package org.example.controllers;

import org.example.FlightSearch;
import org.example.models.Reservation;
import org.example.ReservationService;
import org.example.models.Flight;
import org.example.models.Passenger;

import java.util.List;

public class FlightController {
    private FlightSearch flightSearch;
    private ReservationService reservationService;

    public FlightController(FlightSearch flightSearch, ReservationService reservationService) {
        this.flightSearch = flightSearch;
        this.reservationService = reservationService;
    }

    public List<Flight> searchAvailableFlights(String departure, String destination) {
        return flightSearch.searchFlights(departure, destination);
    }

    public Reservation bookFlight(String flightNumber, Passenger passenger, String seatNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight == null) {
            return null;
        }
        return reservationService.createReservation(flight, passenger, seatNumber);
    }

    private Flight findFlightByNumber(String flightNumber) {
        return flightSearch.getFlights().stream()
                .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElse(null);
    }
}

