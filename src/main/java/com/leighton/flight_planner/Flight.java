package com.leighton.flight_planner;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Flight {
    int flightNumber;
    public String startingPoint;
    public String destination;
    int cost;
    public static String[][] seatMap;
    Timestamp departureTime;
    public static ArrayList<Flight> flights;

    public Flight(int flightNumber, String startingPoint, String destination, int cost, Timestamp departureTime) {
        this.flightNumber = flightNumber;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.cost = cost;
        seatMap = new String[3][2];
        this.departureTime = departureTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public void reserveSeat(int row, int col, String name) {

        if (seatMap[row][col] == null) {
            seatMap[row][col] = name;
        } else {
            throw new RuntimeException("Sorry, this seat is not available");
        }
    }

    public String toString() {
        return "Flight number: " + flightNumber + "\nDestination: " + destination + "\nPrice: $" + cost
                + "\nDeparture time: " + departureTime;
    }

    public boolean isSeatReserved(int row, int col) {
        return seatMap[row][col] != null;
    }

    public static Flight getFlight(ArrayList<Flight> flightInfo, String specificDestination) {
        for (Flight f : flightInfo) {
            if (f.destination.equals(specificDestination)) {
                return f;
            }
        }
        return null;
    }

    public static ArrayList<Flight> loadFlights() {
        flights = new ArrayList<>();
        Timestamp fDepartureTime = Timestamp.valueOf("2023-03-26 9:00:00.000");
        Flight f = new Flight(1, "Berkeley", "Chicago", 1, fDepartureTime);
        flights.add(f);
        return flights;
    }

    public boolean hasSeats(int numSeatsWanted) {
        int remainingAvailableSeats = seatMap.length * seatMap[0].length;
        for (String[] seatsOnOneRow : seatMap) {
            for (int seatIndex = 0; seatIndex < seatMap[0].length; seatIndex++) {
                if (seatsOnOneRow[seatIndex] != null) {
                    remainingAvailableSeats--;
                }
                if (remainingAvailableSeats >= numSeatsWanted) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String getPassengerName(int row, int col) {
        return Flight.seatMap[row][col];
    }
}