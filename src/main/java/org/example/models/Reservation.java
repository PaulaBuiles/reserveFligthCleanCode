package org.example.models;


//La clase Reservation Es experta en la información relacionada con las reservas.
public class Reservation {
    private Flight flight;
    private Passenger passenger;
    private String reservationCode;
    private String seatNumber;

    public Reservation(Flight flight, Passenger passenger, String reservationCode, String seatNumber) {
        this.flight = flight;
        this.passenger = passenger;
        this.reservationCode = reservationCode;
        this.seatNumber = seatNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
