package com.leighton.flight_planner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    @Test
    public void testBasic() {
        Flight f = new Flight(44, "Boeing 727");
        assertEquals(44, f.getNumber());
    }
}
