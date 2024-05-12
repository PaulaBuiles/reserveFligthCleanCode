package org.example.services;

import org.example.models.Flight;
import org.example.models.Passenger;
import org.example.models.Reservation;

//Cada método realiza una sola acción. Funciones pequeñas enfocadas en una sola tarea
public class ReservationService {

    public Reservation createReservation(Flight flight, Passenger passenger, String seatNumber) {
        String reservationCode = generateReservationCode(flight, passenger);
        return new Reservation(flight, passenger, reservationCode, seatNumber);
    }

    private String generateReservationCode(Flight flight, Passenger passenger) {
        return flight.getFlightNumber() + "-" + passenger.getPassportNumber();
    }
}
