package org.example.services;

import org.example.models.Flight;

import java.util.List;
import java.util.stream.Collectors;

// La clase FlightSearch cumple con el patron Creator crea instancias de vuelos disponibles al buscar vuelos por origen y destino.
// Es responsable de crear y devolver una lista de vuelos que coinciden con los criterios de búsqueda.
public class FlightSearch {

    private List<Flight> flights;

    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> searchFlights(String departure, String destination) {
        return flights.stream()
                .filter(flight -> matchesDeparture(flight, departure))
                .filter(flight -> matchesDestination(flight, destination))
                .collect(Collectors.toList());
    }

    private boolean matchesDeparture(Flight flight, String departure) {
        return departure == null || departure.isEmpty() || flight.getDeparture().equalsIgnoreCase(departure);
    }

    private boolean matchesDestination(Flight flight, String destination) {
        return destination == null || destination.isEmpty() || flight.getDestination().equalsIgnoreCase(destination);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}

