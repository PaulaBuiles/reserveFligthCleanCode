package org.example;

import org.example.controllers.FlightController;
import org.example.models.Flight;
import org.example.models.Passenger;
import org.example.models.Reservation;
import org.example.services.FlightSearch;
import org.example.services.ReservationService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Flight flight1 = new Flight("FL100", "Medellín", "Bogotá", LocalDateTime.of(2024, 5, 20, 15, 30));
        Flight flight2 = new Flight("FL101", "Bogotá", "Miami", LocalDateTime.of(2024, 5, 21, 10, 0));
        Flight flight3 = new Flight("FL102", "Medellín", "Madrid", LocalDateTime.of(2024, 5, 22, 23, 45));


        List<Flight> flights = Arrays.asList(flight1, flight2, flight3);


        FlightSearch flightSearch = new FlightSearch(flights);
        ReservationService reservationService = new ReservationService();


        FlightController controller = new FlightController(flightSearch, reservationService);


        List<Flight> availableFlights = controller.searchAvailableFlights("Medellín", "");
        System.out.println("Vuelos disponibles desde Medellín: " + availableFlights);


        Flight selectedFlight = availableFlights.get(0);


        Passenger passenger = new Passenger("Juan Pérez", "AB1234567");


        Reservation reservation = controller.bookFlight(selectedFlight.getFlightNumber(), passenger, "12A");
        System.out.println("Reserva realizada con éxito: " + reservation);
    }
}
