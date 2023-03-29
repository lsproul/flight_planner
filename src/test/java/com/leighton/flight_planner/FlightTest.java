package com.leighton.flight_planner;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    @Test
    public void testBasic() {
        Flight f = new Flight(44, "Berkeley", "Tucson", 1, Timestamp.valueOf("2023-01-15 10:00:00"));
        assertEquals(44, f.getFlightNumber());
    }

    @Test
    public void testReserveSeat() {
        String userName = "bob";
        Flight f = new Flight(44, "Berkeley", "Tucson", 1, Timestamp.valueOf("2023-01-15 10:00:00"));
        f.reserveSeat(1, 1, "bob");
        assertEquals(userName, Flight.getPassengerName(1, 1));
    }

    @Test
    public void testHasSeats(){
        Flight.loadFlights();
        Flight f = new Flight(44, "Berkeley", "Tucson", 1, Timestamp.valueOf("2023-01-15 10:00:00"));
        assertFalse(f.hasSeats(7));

    }


}
