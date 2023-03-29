package com.leighton.flight_planner;

import java.util.ArrayList;
import java.util.HashMap;

public class SeatMap {

    private HashMap<String, String> seatNameToPassengerName = new HashMap<>();

    public SeatMap() {
        for (int row = 1; row < 5; row++) {
            String z = "abcdef";
            for (int col = 0; col < z.length; col++) {
                String seatCode = "" + row + z.charAt(col);
                seatNameToPassengerName.put(seatCode, null);
            }
        }
    }

    public String[] getFreeSeats(int numOfSeatsWanted) {
        
    }

    public void reserveSeats(HashMap<String, String> seatNameToNewPassengerName) {
        for (String seatCode : seatNameToNewPassengerName.keySet()) {
            String newPassengerName = seatNameToNewPassengerName.get(seatCode);
            seatNameToPassengerName.put(seatCode, newPassengerName);
        }
    }

    public String getPassengerNameBySeatCode(String seatCode) {
        if (!seatNameToPassengerName.containsKey(seatCode)) {
            return "Sorry, but this seat code does not exist";
        } else if (seatNameToPassengerName.get(seatCode).equals(null)) {
            return "This seat is not occupied";
        }
        return seatNameToPassengerName.get(seatCode);
    }

}


