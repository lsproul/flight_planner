package com.leighton.flight_planner;

public class SeatUnavaliableException extends Exception{
    public SeatUnavaliableException(String Errormessage){
        super(Errormessage);
    }
}
