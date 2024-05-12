package org.example.models;

import java.time.LocalDateTime;

//La clase Flight usa Expert ya que es experta en conocer los detalles específicos de un vuelo. Contiene los atributos y métodos relacionados con la información de vuelo.
public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;

    public Flight(String flightNumber, String departure, String destination, LocalDateTime departureTime) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
