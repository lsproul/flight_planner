package com.leighton.flight_planner;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String command;
        System.out.println("enter the destination you want to book a flight to");
        command = scan.nextLine();
        Flight.loadFlights();
        System.out.println(Flight.getFlight(Flight.flights, command));
        scan.close();

    }
}