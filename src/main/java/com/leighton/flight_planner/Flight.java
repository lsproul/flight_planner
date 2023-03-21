package com.leighton.flight_planner;
public class Flight {
    public int getNumber() {
        return number;
    }

    int number;
    Plane plane;
    public Flight(int number, String plane_type) {
        plane = new Plane(plane_type);
        this.number = number;
    }
}
