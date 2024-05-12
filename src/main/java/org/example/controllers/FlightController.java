package org.example.controllers;

import org.example.services.FlightSearch;
import org.example.models.Reservation;
import org.example.services.ReservationService;
import org.example.models.Flight;
import org.example.models.Passenger;

import java.util.List;

//Este es Controller. Coordina las acciones del usuario, como buscar vuelos y realizar reservas.
// También maneja la interacción entre las clases FlightSearch y ReservationService.
public class FlightController {
    private FlightSearch flightSearch;
    private ReservationService reservationService;

    public FlightController(FlightSearch flightSearch, ReservationService reservationService) {
        this.flightSearch = flightSearch;
        this.reservationService = reservationService;
    }

    //Se usan nombres claros y descriptivos, tanto para métodos, como variables y clases
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

